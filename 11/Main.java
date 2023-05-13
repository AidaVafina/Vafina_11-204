public class Main {
    public static void main(String[] args) throws Exception {
        User animal =
                new User("+79874217557","192.168.0.3");

        User animal1 =
                new User("+79874217557","27.06.2004");


        System.out.println(CheckValueAnnotationValidator.isValid(User.class,animal));
        System.out.println(CheckValueAnnotationValidator.isValid(User.class,animal1));

    }
}