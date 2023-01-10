import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductManager {
    private ArrayList<Product>listProduct;
    public ProductManager(){
        listProduct= new ArrayList<>();
    }
    public ArrayList<Product> getListProduct(){
        return listProduct;
    }
    public String path= "C:\\Users\\PC\\OneDrive\\Desktop\\Module 2\\TestModule2\\Module2\\src\\product.csv";
    static int index = 0;
    public Product creat(Scanner scanner){
        int id;
        if (listProduct.isEmpty()) {
            id = index + 1;
        } else {
            id = listProduct.get(listProduct.size() - 1).getId() + 1;
        }
        System.out.println("Nhập tên sản phẩm mới: ");
        String name = scanner.nextLine();
        boolean check = true;
        double price = 0;
        while (check) {
            try {
                System.out.println("Nhập giá sản phẩm : ");
                price = Double.parseDouble(scanner.nextLine());
                check = false;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Bạn nhập sai định dạng. Nhập lại.");
            }
        }
        check = true;
        int quantity= 0;
        while (check) {
            try {
                System.out.println("Nhập số lượng sản phẩm : ");
                quantity = Integer.parseInt(scanner.nextLine());
                check = false;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Bạn nhập sai định dạng. Nhập lại.");
            }
        }
        System.out.println("Nhập mô tả của sản phẩm: ");
        String description = scanner.nextLine();
        return new Product(id,name,price,quantity,description);
    }
    public void add(Product product){
        listProduct.add(product);
        System.out.println("Thêm thành công!");
        title();
        product.display();
    }
    public void update(Scanner scanner){
        boolean check = true;
        int id = 0;
        while (check){
            try{
                System.out.println("Nhập ID sản phẩm cần sửa: ");
                id = Integer.parseInt(scanner.nextLine());
                check =false;
            }catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Bạn nhập sai định dạng. Nhập lại.");
            }
        }
        if (checkID(id)){
                boolean check1 = true;
                int idNew = 0;
                while (check1){
                    try{
                        System.out.println("Nhập ID sản phẩm cần sửa: ");
                        idNew = Integer.parseInt(scanner.nextLine());
                        check1 =false;
                    }catch (InputMismatchException | NumberFormatException exception) {
                        System.out.println("Bạn nhập sai định dạng. Nhập lại.");
                    }
                }
                for (Product e : listProduct){
                    if (id == e.getId()){
                        e.setId(idNew);
                        check1 = true;
                        System.out.println("Nhập tên sản phẩm:");
                        String name = scanner.nextLine();
                        e.setName(name);
                        double price = 0;
                        while (check1) {
                            try {
                                System.out.println("Nhập giá sản phẩm : ");
                                price = Double.parseDouble(scanner.nextLine());
                                check1 = false;
                            } catch (InputMismatchException | NumberFormatException exception) {
                                System.out.println("Bạn nhập sai định dạng. Nhập lại.");
                            }
                        }
                        e.setPrice(price);
                        check1 = true;
                        int quantity= 0;
                        while (check1) {
                            try {
                                System.out.println("Nhập số lượng sản phẩm : ");
                                quantity = Integer.parseInt(scanner.nextLine());
                                check1 = false;
                            } catch (InputMismatchException | NumberFormatException exception) {
                                System.out.println("Bạn nhập sai định dạng. Nhập lại.");
                            }
                        }
                        e.setQuantity(quantity);
                        System.out.println("Nhập mô tả của sản phẩm: ");
                        String description = scanner.nextLine();
                        e.setDescription(description);
                        System.out.println("Cập nhật thông tin thành công.");
                    }
                    }

        }else {
            System.out.println("Không tìm được sản phẩm với mã sản phẩm ở trên.");
        }

    }
    public void title(){
        System.out.printf("%-15s%-30s%-20s%-20s%s",
                "ID","NAME","GIÁ","SỐ LƯỢNG","MÔ TẢ\n");
    }
    public void displayAll(ArrayList<Product>listProduct){
        if (!listProduct.isEmpty()) {
            System.out.println("Danh sách sản phẩm: ");
            title();
            for (Product e : listProduct) {
                e.display();
            }
        } else {
            System.out.println("Không có sản phẩm nào trong danh sách.");
        }
    }
    public boolean checkID(int idCheck){
        for (Product e : listProduct){
            if (idCheck==e.getId()){
                return true;
            }
        }return false;
    }
    public void deleteByID(Scanner scanner){
        boolean check = true;
        int id = 0;
        while (check){
            try{
                System.out.println("Nhập ID sản phẩm cần xóa: ");
                id = Integer.parseInt(scanner.nextLine());
                check =false;
            }catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Bạn nhập sai định dạng. Nhập lại.");
            }
        }
        if (checkID(id)){
            for (Product e : listProduct){
                if (id == e.getId()){
                    System.out.println("Thông tin sảnn phẩm:");
                    title();
                    e.display();
                    System.out.println("Bạn có muốn xóa sản phẩm. Nhập Y để tiếp tục");
                    String choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("Y")){
                        listProduct.remove(e);
                        System.out.println("Xóa sản phẩm thành công.");
                    }else {
                        System.out.println("Sản phẩm không được xóa.");
                        break;
                    }
                }
            }
        }else {
            System.out.println("Không tìm được mã sản phẩm ở trên.");
        }
    }
    public void maxPrice(){
        ArrayList<Product> listMaxPrice = new ArrayList<>();
        if (!listProduct.isEmpty()){
            double max = listProduct.get(0).getPrice();
            for (Product e: listProduct) {
                if (max < e.getPrice()){
                    double temp = e.getPrice();
                    e.setPrice(max);
                    max = temp;
                }
            }
            for (Product e:listProduct) {
                if (max == e.getPrice()){
                    listMaxPrice.add(e);
                }
            }
            System.out.println("Danh sách sản phẩm có giá lớn nhất là: ");
            title();
            for (Product e : listMaxPrice) {
                e.display();
            }
        }else {
            System.out.println("Không có sản phẩm nào trong danh sách.");
        }
    }
    public void displayByPriceUp() {
        System.out.println("List product by up price: ");
        listProduct.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() > o2.getPrice() ? 1 : -1;
            }
        });
        displayAll(listProduct);
    }
    public void displayByPriceDown(){
        System.out.println("List product by up price: ");
        listProduct.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() < o2.getPrice() ? 1 : -1;
            }
        });
        displayAll(listProduct);
    }
    public void writeFile(ArrayList<Product> list, String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (Product product : list) {
                bw.write(product.toString());
                bw.newLine();

            }
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        }

    public ArrayList<Product> readFile(String path){
        ArrayList<Product> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader br = new BufferedReader(fileReader);
            String line = "";
            while ((line=br.readLine())!=null){
                String [] txt = line.split(";");
                int id = Integer.parseInt(txt[0]);
                String name = txt[1];
                double price = Double.parseDouble(txt[2]);
                int quantity = Integer.parseInt(txt[3]);
                String detail = txt[4];
                list.add(new Product(id,name,price,quantity,detail));
            }
            br.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return list;
    }

}
