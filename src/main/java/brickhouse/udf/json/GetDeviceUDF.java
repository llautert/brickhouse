package brickhouse.udf.json;

import java.util.ArrayList;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;

@Description(name="get_device",
      value = "_FUNC_(string)"

) public class GetDeviceUDF extends UDF {

   public String evaluate(String os, String source) {
      try {
         if(source == "desktop")
            return "web";

         if(source == "mobile")
            return source;

         if(source != null)
            return "api." + source;

         if(os == null ||
            os.equalsIgnoreCase("null") ||
            os.equalsIgnoreCase("[]"))
            return null;

         if(os.toLowerCase().contains("windows phone") ||
            os.toLowerCase().contains("symbian") ||
            os.toLowerCase().contains("android") ||
            os.toLowerCase().contains("ios") ||
            os.toLowerCase().contains("blackberry"))
            return "mobile";

         return "web";

      } catch (NullPointerException npe){
         return null;
      }
   }
}
