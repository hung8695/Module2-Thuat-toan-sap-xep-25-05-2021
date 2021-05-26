
import java.util.*;

public class Manage {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Document> listDocumet;

    public Manage() {
        listDocumet = new ArrayList<>();
    }

    void display() {
        Iterator<Document> iterator = listDocumet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

    }

    void add(Document document) {
        listDocumet.add(document);
    }


    void addBook() {
        Book book = new Book();
        System.out.println("Nhập tên: ");
        book.setName(scanner.nextLine());
        System.out.println("Tên nhà xuất bản: ");
        book.setNxb(scanner.nextLine());
        System.out.println("Số phát hành: ");
        book.setSoBanPhatHanh(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Giá tiền: ");
        book.setPrice(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Tên tác giả: ");
        book.setTenTacGia(scanner.nextLine());
        listDocumet.add(book);
    }

    void addNewspaper() {
        Newspaper newspaper = new Newspaper();
        System.out.println("Nhà xuất bản: ");
        newspaper.setNxb(scanner.nextLine());
        System.out.println("Số phát hành: ");
        newspaper.setSoBanPhatHanh(scanner.nextInt());
        System.out.println("Giá tiền: ");
        newspaper.setPrice(scanner.nextInt());
        scanner.nextLine();
        // System.out.println("Ngày phát hành: ");
        newspaper.setDate(enterDate());
        listDocumet.add(newspaper);
    }

    String enterDate() {
        int day, month, year;
        do {
            System.out.println("Nhập ngày: ");
            day = scanner.nextInt();
            System.out.println("Nhập tháng: ");
            month = scanner.nextInt();
            System.out.println("Nhập năm: ");
            year = scanner.nextInt();
        } while (checkDate(day, month, year));

        return day + "/" + month + "/" + year;
    }

    boolean checkDate(int day, int month, int year) {
        int[] dayMax = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (checkYear(year)) {
            dayMax[2] = 29;
        }
        if(year<0){
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (day > dayMax[month] || 0 <= day || day > 31) {
            return false;
        }
        if (0 <= month || month > 12) {
            return false;
        }
        return true;
    }

    boolean checkYear(int year) {
        return (((year % 4 == 0) && (year % 100 != 0)) ||
                (year % 400 == 0));
    }

    void find() {
        boolean find = false;
        System.out.println("Nhập thông tin tìm kiếm: ");
        String str = scanner.nextLine();
        System.out.println("Kết quả tìm kiếm: ");
        for (Document document : listDocumet) {
            if (document instanceof Book) {
                if (((Book) document).getId().equals(str) || ((Book) document).getName().equals(str) ||
                        document.getNxb().equals(str) || ((Book) document).getTenTacGia().equals(str) ||
                        (Integer.toString(document.getSoBanPhatHanh()).equals(str)) ||
                        Integer.toString(document.getPrice()).equals(str)) {
                    System.out.println(document.toString());
                    find=true;
                }
            }
            if (document instanceof Newspaper) {
                if (((Newspaper) document).getDate().equals(str) || ((Newspaper) document).getId().equals(str) ||
                        Integer.toString(document.getPrice()).equals(str)
                ) {
                    System.out.println(document.toString());
                    find=true;
                }
            }
        }
        if (!find) {
            System.out.println("Không tìm thấy thông tin đã nhập");
        }
    }

    void findPriceRange() {
        System.out.println("Nhập khoảng giá tiền : ");
        System.out.print("Từ: ");
        int min = scanner.nextInt();
        System.out.print("Đến: ");
        int max = scanner.nextInt();
        scanner.nextLine();
        boolean find = false;
        System.out.println("Kết quả tìm kiếm trong khoảng giá " + "[" + min + "-" + max + "]");
        for (Document document : listDocumet) {
            if (document.getPrice() >= min && document.getPrice() <= max) {
                System.out.println(document.toString());
                find = true;
            }

        }
        if (!find) {
            System.out.println("Không tìm thấy sách trong khoảng giá " + "[" + min + "-" + max + "]");
        }
    }

    Document findById(String id) {
        for (Document document : listDocumet) {
            if (document.getId().equals(id)) {
                return document;
            }
        }
        return null;
    }

    void edit() {
        System.out.println("Nhập Id cần sửa: ");
        String ID = scanner.nextLine();

        if (findById(ID) instanceof Book) {
            System.out.println("Nhập tên: ");
            ((Book) findById(ID)).setName(scanner.nextLine());
            System.out.println("Tên nhà xuất bản: ");
            findById(ID).setNxb(scanner.nextLine());
            System.out.println("Số phát hành: ");
            findById(ID).setSoBanPhatHanh(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Giá tiền: ");
            findById(ID).setPrice(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Tên tác giả: ");
            ((Book) findById(ID)).setTenTacGia(scanner.nextLine());
        } else if (findById(ID) instanceof Newspaper) {
            findById(ID).setNxb(scanner.nextLine());
            System.out.println("Số phát hành: ");
            findById(ID).setSoBanPhatHanh(scanner.nextInt());
            System.out.println("Giá tiền: ");
            findById(ID).setPrice(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Ngày phát hành: ");
            ((Newspaper) findById(ID)).setDate(scanner.nextLine());
        } else
            System.out.println("Không tìm thấy Id này trong danh sách");
    }

    void sortById() {
        Collections.sort(listDocumet, new Comparator<Document>() {
            @Override
            public int compare(Document o1, Document o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
    }

    void sortByPrice() {
        Collections.sort(listDocumet, new Comparator<Document>() {
            @Override
            public int compare(Document o1, Document o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }

    void delete() {
        System.out.println("Nhập Id cần xóa!");
        String id = scanner.nextLine();
        if (findById(id) != null) {
            listDocumet.remove(findById(id));
        } else
            System.out.println("Không tìm thấy ID trên");
    }

    void menu() {
        System.out.println("-- ------QUẢN LÝ SÁCH-------");
        System.out.printf("%-12s%-12s%s\n", "1. Thêm", "2. Sửa", "3. Xóa");
        System.out.printf("%-12s%-12s%s\n", "4. Tìm ", "5. Sắp xếp", "6. Hiển thị");
        System.out.println("7. Thoát");
    }

    void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            menu();
            System.out.println("Nhập lựa chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("a-Thêm sách: ");
                    System.out.println("b-Thêm báo: ");
                    System.out.println("Select: ");
                    String select0 = scanner.nextLine();
                    switch (select0) {
                        case "a":
                            addBook();
                            break;
                        case "b":
                            addNewspaper();
                            break;
                    }
                    break;
                case 2:
                    edit();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    System.out.println("a- Tìm kiếm theo tên, Id, nhà xuất bản, tác giả, ngày sản xuất ");
                    System.out.println("b- Tìm kiếm theo khoảng giá");
                    System.out.println("Select: ");
                    String select = scanner.nextLine();
                    switch (select) {
                        case "a":
                            find();
                            menu1();
                            break;
                        case "b":
                            findPriceRange();
                            menu1();
                            break;
                    }
                    break;
                case 5:
                    System.out.println("a- Sắp xếp theo Id");
                    System.out.println("b- Sắp xếp theo giá");
                    System.out.println("Select: ");
                    String select1 = scanner.nextLine();
                    switch (select1) {
                        case "a":
                            sortById();
                            break;
                        case "b":
                            sortByPrice();
                            break;
                    }
                    break;
                case 6:
                    display();
                    menu1();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        } while (choice > 0 && choice <= 7);
    }

    void menu1() {
        System.out.println("Bấm Enter để quay lại Menu");
        scanner.nextLine();
    }

    void init() {
        listDocumet.add(new Book("Sóng", "Hà Nội", 1000, 200, "Xuân Quỳnh"));
        listDocumet.add(new Book("Đây thôn Vĩ Dạ", "Giáo dục", 1200, 300, "Hàn Mặc Tử"));
        listDocumet.add(new Newspaper("Huhu", 1000, 300, "05/05/2020"));
        listDocumet.add(new Newspaper("Hà Nội", 500, 1600, "01/01/2021"));
    }
}
