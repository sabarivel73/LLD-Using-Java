public class User {
    private String name;
    private int age;
    private String email;
    private String password;
    public User(String name,int age,String email,String password)
    {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }
    public void set_name(String name)
    {
        this.name = name;
    }
    public String get_name()
    {
        return name;
    }
    public void set_age(int age)
    {
        this.age = age;
    }
    public int get_age()
    {
        return age;
    }
    public void set_email(String email)
    {
        this.email = email;
    }
    public String get_email()
    {
        return email;
    }
    public void set_password(String password)
    {
        this.password = password;
    }
    public String get_password()
    {
        return password;
    }
}
