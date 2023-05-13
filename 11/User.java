import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
На 0.5: изменить аннотацию CheckValue
 так, чтобы она принимала массив строк. ☑

  Переписать CheckValueAnnotationValidator
   так, чтобы он проверил соответствие поля
    класса указанным строкам в CheckValue.
 */



@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @CheckValue(pattern = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")
    private String goBird;

    @CheckValue(pattern = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)")
    private String ip;
}
