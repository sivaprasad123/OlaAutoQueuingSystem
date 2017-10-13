package com.youplus.core.utils;

import java.util.Date;

/**
 * Created by siva on 12/10/17.
 */
public class DateUtils {

  private DateUtils() {
  }

  public static String getElapsedDate(Date d1, Date d2) {
    StringBuilder builder = new StringBuilder();
    long diff = d2.getTime() - d1.getTime();
    long diffSeconds = diff / 1000 % 60;
    long diffMinutes = diff / (60 * 1000) % 60;
    long diffHours = diff / (60 * 60 * 1000) % 24;
    long diffDays = diff / (24 * 60 * 60 * 1000);
    if (diffDays > 0) {
      builder.append(diffDays + " day ");
    }
    if (diffHours > 0) {
      builder.append(diffHours + " hr ");
    }
    if (diffMinutes > 0) {
      builder.append(diffMinutes + " min ");

    }
    if (diffSeconds > 0) {
      builder.append(diffSeconds + " sec ");

    }
    return builder.toString();
  }
  public static String getDateInString(Date d1, Date d2) {
    StringBuilder builder = new StringBuilder();
    long diff = d2.getTime() - d1.getTime();
    long diffMinutes = diff / (60 * 1000) % 60;
    if (diffMinutes > 0) {
      builder.append(diffMinutes + " mins ago ");
    }else {
      builder.append("just now");
    }
    return builder.toString();
  }
}
