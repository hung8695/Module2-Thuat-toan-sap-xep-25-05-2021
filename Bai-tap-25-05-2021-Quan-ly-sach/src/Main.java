public class Main {
    public static void main(String[] args) {
        Manage manage=new Manage();
        manage.add(new Book("Sóng","Hà Nội",1000,300,"Xuân Quỳnh"));
        manage.add(new Book("Đây thôn Vĩ Dạ","Giáo dục",1200,300,"Hàn Mặc Tử"));
        manage.add(new Book("Huhu","Hihi",1000,300,"Hưng"));
        manage.add(new Newspaper("Hà Nội",500,1600,"01/01/2021"));
        manage.start();
    }
}
