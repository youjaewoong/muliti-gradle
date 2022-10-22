package cdp.common.config.mybatis;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.core.io.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * Mybatis XML 을 Application Rintime 시에 갱신 할 수 있도록 합니다.
 *
 * Reference : https://oingdaddy.tistory.com/392
 */
@Slf4j
public class RefreshableSqlSessionFactoryBean extends SqlSessionFactoryBean implements DisposableBean {

	private SqlSessionFactory proxy;
	private int interval = 1000;
	private Timer timer;
	private TimerTask task;
	private Resource[] mapperLocations;
	private boolean running = false;
	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private final Lock r = rwl.readLock();
	private final Lock w = rwl.writeLock();

	public void setMapperLocations(Resource[] mapperLocations) {
		super.setMapperLocations(mapperLocations);
		this.mapperLocations = mapperLocations;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public void refresh() throws Exception {
		w.lock();
		try {
			super.afterPropertiesSet();
		} finally {
			w.unlock();
		}
		log.info("sqlMapClient refreshed.");
	}

	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
	}

	private void setRefreshable() {
		proxy = (SqlSessionFactory)Proxy.newProxyInstance(SqlSessionFactory.class.getClassLoader(),
				new Class[] {SqlSessionFactory.class}, new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws
							Throwable {return method.invoke(getParentObject(), args);}
				});

		task = new TimerTask() {
			private Map<Resource, Long> map = new HashMap<>();

			public void run() {
				if (isModified()) {
					try {
						refresh();
					} catch (Exception e) {
						log.error("caught exception", e);
					}
				}
			}

			private boolean isModified() {
				boolean retVal = false;
				if (mapperLocations != null) {
					for (int i = 0; i < mapperLocations.length; i++) {
						Resource mappingLocation = mapperLocations[i];
						retVal |= findModifiedResource(mappingLocation);
					}
				}
				return retVal;
			}

			private boolean findModifiedResource(Resource resource) {
				boolean retVal = false;
				List<String> modifiedResources = new ArrayList<>();
				try {
					Long modified = resource.lastModified();
					if (map.containsKey(resource)) {
						Long lastModified = map.get(resource);
						if (lastModified.longValue() != modified.longValue()) {
							map.put(resource, modified);
							modifiedResources.add(resource.getDescription());
							retVal = true;
						}
					} else {
						map.put(resource, modified);
					}
				} catch (IOException e) {
					log.error("caught exception", e);
				}

				if (retVal) {
					log.info("modified files : " + modifiedResources);
				}
				return retVal;
			}
		};
		timer = new Timer(true);
		resetInterval();
	}

	private Object getParentObject() throws Exception {
		r.lock();
		try {
			return super.getObject();
		} finally {
			r.unlock();
		}
	}

	public SqlSessionFactory getObject() throws Exception {
		if (this.proxy == null) {
			setRefreshable();
		}
		return this.proxy;
	}

	public Class<? extends SqlSessionFactory> getObjectType() {
		return (this.proxy != null ? this.proxy.getClass() : SqlSessionFactory.class);
	}

	public boolean isSingleton() {
		return true;
	}

	public void setCheckInterval(int ms) {
		interval = ms;
		if (timer != null) {
			resetInterval();
		}
	}

	private void resetInterval() {
		if (running) {
			timer.cancel();
			running = false;
		}
		if (interval > 0) {
			timer.schedule(task, 0, interval);
			running = true;
		}
	}

	public void destroy() throws Exception {
		timer.cancel();
	}

}
