public class Main {
    public static class fun {
        private int id;
        private String name;
        private String email;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String toString() {
            return id+"\n"+name+"\n"+email+"\n";
        }
    }
    public static void main(String[] args) {
        fun v1 = new fun();
        v1.setId(1);
        v1.setName("Sabari");
        v1.setEmail("sabarivel0928@gmail.com");
        IO.println(v1.toString());
    }
}
