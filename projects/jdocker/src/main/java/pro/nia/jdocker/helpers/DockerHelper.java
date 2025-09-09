package pro.nia.jdocker.helpers;

import org.apache.commons.io.FileUtils;

public class DockerHelper {

  public static String make_short_id(String id) {
    String[] split_result = id.split(":");
    if (split_result.length < 2) {
      return id;
    }

    return split_result[1].substring(0, 12);

  }

  public static String humanize_size(Long value) {
    return FileUtils.byteCountToDisplaySize(value);
  }

  public static String timestamp_2_date(Long value) {

    // NOTE: multi to 1000 - msec
    java.util.Date time = new java.util.Date(value * 1000);

    // TODO: format
    // LocalDate date = LocalDate.now();
    // System.out.println(date.toString());
    // System.out.println(time.toString());
    // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
    // String text = date.format(formatter);
    // System.out.println(text);

    // DateFormat formatter = DateFormat.getDateTimeInstance();
    // return formatter.format(this);

    // кривой буржуйский формат...
    return time.toString();
  }

}
