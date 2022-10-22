package cdp.common.util;

public class ReplaceRegularUtil {
	public static String toReplaceRegular(String source) {

		/*
		ASIS와 맞추어 구현해뒀지만, HTML 태그를 없애는 용도라면 아래와 같이 한줄로 처리 예정.
		return source.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "")
		 */

		source = source.replaceAll("<[/]*(javascript|script|iframe|object|applet|xml|form|marquee|meta|embed|vbscript|cookie|location)[^>]*>","")
		.replaceAll("<(javascript|script|iframe|object|applet|xml|form|marquee|meta|embed|vbscript|cookie|location)[^>]*>", "")
		.replaceAll("<[^<]*(javascript|script|vbscript|cookie|location|onclick|onmouse|onfocus|onload|input|pre|nowrap|bgsound)[^>]*>", "")
		.replaceAll("<[^<]*(onclick|onchange|onfocus|onfocusin|onfocusout|oninput|oninvalid|onreset|onsearch|onsubmit)[^>]*>", "")
		//Mouse Events
		.replaceAll("<[^<]*(onclick|oncontextmenu|ondblclick|onmousedown|onmouseenter|onmouseleave|onmousemove|onmouseover|onmouseout|onmouseup)[^>]*>", "")
		//Keyword Events
		.replaceAll("<[^<]*(onkeydown|onkeypress|onkeyup)[^>]*>", "")
		//Frame/Object Events
		.replaceAll("<[^<]*(onabort|onbeforeunload|onerror|onhashchange|onload|onpageshow|onpagehide|onresize|onscroll|onunload)[^>]*>", "")
		//Form Events
		.replaceAll("<[^<]*(onblur|onchange|onfocus|onfocusin|onfocusout|oninput|oninvalid|onreset|onsearch|onsubmit)[^>]*>", "")
		//Drag Events
		.replaceAll("<[^<]*(ondrag|ondragend|ondragenter|ondragleave|ondragover|ondragstart|ondrop)[^>]*>", "")
		//Clipboard Events
		.replaceAll("<[^<]*(oncopy|oncut|onpaste)[^>]*>", "")
		//Print Events
		.replaceAll("<[^<]*(onafterprint|onbeforeprint)[^>]*>", "")
		//Media Events
		.replaceAll("<[^<]*(onabort|oncanplay|oncanplaythrough|ondurationchange|onemptied|onended|onerror|onloadeddata|onloadedmetadata|onloadstart|onpause|onplay|onplaying|onprogress|onratechange|onseeked|onseeking|onstalled|onsuspend|ontimeupdate|onvolumechange|onwaiting)[^>]*>", "")
		//Animation Events
		.replaceAll("<[^<]*(animationend|animationiteration|animationstart)[^>]*>", "")
		//Transition Events
		.replaceAll("<[^<]*(transitionend)[^>]*>", "")
		//Server-Sent Events
		.replaceAll("<[^<]*(onerror|onmessage|onopen)[^>]*>", "")
		//Misc Events
		.replaceAll("<[^<]*(onmessage|onmousewheel|ononline|onoffline|onpopstate|onshow|onstorage|ontoggle|onwheel)[^>]*>", "")
		//Touch Events
		.replaceAll("<[^<]*(ontouchcancel|ontouchend|ontouchmove|ontouchstart)[^>]*>", "");
				
		return source;
		
	}
}
