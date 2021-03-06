package com.dyx.wvah.utils;

/**
 * project name：WoChu4.0AS
 * class describe：
 * create person：dayongxin
 * create time：16/8/8 下午4:33
 * alter person：dayongxin
 * alter time：16/8/8 下午4:33
 * alter remark：
 */
public class HtmlUtil {
    public static String getFormatHtml(String details) {
        StringBuilder sb = new StringBuilder();
        sb.append("<head>");
        sb.append("<link type=\"text/css\" rel=\"stylesheet\" href=\"themes/benlai/style2.css\">");
        sb.append("<link type=\"text/css\" rel=\"stylesheet\" href=\"themes/benlai/style.css\">");
        sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=1, minimum-scale=1.0, maximum-scale=1.0\" />");
        sb.append("</head>");
        sb.append("<body>");
        sb.append(details);
        sb.append("<style type=\"text/css\"> img { max-width:100%;height:auto} table { max-width:100%;}  </style>");
        sb.append("</body>");
        return sb.toString();
    }
}
