import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckValueAnnotationValidator {
    public static boolean isValid(Class clazz, Object object) throws Exception{
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            if(field.getAnnotation(CheckValue.class) != null){
                CheckValue annnotation = field.getAnnotation(CheckValue.class);
                Pattern pattern = Pattern.compile(annnotation.pattern());
                String name = (String)field.get(object);
                Matcher matcher = pattern.matcher(name);
                if(!matcher.find()){
                    return false;
                }
            }
        }
        return true;
    }
}