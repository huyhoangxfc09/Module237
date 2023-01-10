import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        mennuProduct(productManager,scanner);
    }
    public static void mennuProduct(ProductManager productManager, Scanner scanner) {
        int choice;
        boolean check = true;
        while (check) {
            try {
                do {
                    System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM-----");
                    System.out.println("1. Xem danh sách.");
                    System.out.println("2. Thêm mới. ");
                    System.out.println("3. Cập nhật. ");
                    System.out.println("4. Xóa. ");
                    System.out.println("5. Sắp xếp.");
                    System.out.println("6. Tìm sản phẩm có giá lớn nhất.");
                    System.out.println("7. Đọc từ file.");
                    System.out.println("8. Ghi vào file.");
                    System.out.println("9. Thoát.");
                    System.out.println("Enter your choice: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            productManager.readFile(productManager.path);
                            productManager.displayAll(productManager.getListProduct());
                            check = false;
                            break;
                        case 2:
                            Product product = productManager.creat(scanner);
                            productManager.add(product);
                            productManager.writeFile(productManager.getListProduct(),productManager.path);
                            check = false;
                            break;
                        case 3:
                            productManager.update(scanner);
                            productManager.writeFile(productManager.getListProduct(),productManager.path);
                            check = false;
                            break;
                        case 4:
                            productManager.deleteByID(scanner);
                            productManager.writeFile(productManager.getListProduct(),productManager.path);
                            check = false;
                            break;
                        case 5:
                            menuSort(productManager,scanner);
                            check = false;
                            break;
                        case 6:
                            productManager.maxPrice();
                            check = false;
                            break;
                        case 7:
                            productManager.writeFile(productManager.getListProduct(),productManager.path);
                            check = false;
                            break;
                        case 8:
                            productManager.readFile(productManager.path);
                            check = false;
                            break;
                        case 9:
                            check = false;
                            break;
                    }
                } while (choice != 9);
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Re-enter choice.");
            }
        }
    }

    public static void menuSort(ProductManager productManager,Scanner scaner) {
        int choice;
        boolean check = true;
        while (check) {
            try {
                do {
                    System.out.println("-----Sắp xếp-----");
                    System.out.println("1. Sắp xếp giá tăng dần.");
                    System.out.println("2. Sắp xếp giá giảm dần. ");
                    System.out.println("3. Thoát. ");
                    System.out.println("Nhập lựa chọn: ");
                    choice = Integer.parseInt(scaner.nextLine());
                    switch (choice) {
                        case 1:
                            productManager.displayByPriceUp();
                            check = false;
                            break;
                        case 2:
                            productManager.displayByPriceDown();
                            check = false;
                            break;
                        case 3:
                            check = false;
                            break;
                    }
                } while (choice != 3);
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Nhập lựa chọn.");
            }
        }
    }

}
