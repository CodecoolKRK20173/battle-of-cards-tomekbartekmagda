
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.HashMap;

public class MenuFileReader {
    private HashMap<String, ArrayList<String>> menuList;
    private final static String PATH = "";
    
    public MenuFileReader(String fileName) {
        menuList = new HashMap<>();
        LoadMenuFromFile(fileName);
    }

    private boolean isLineNewMenu(String fileLine){
        return fileLine.contains("*");
    }

    private String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }

    private void addMenuToMenuMap(BufferedReader br) throws IOException{
        ArrayList<String> tempArray = new ArrayList<>();
        String menuLine = "";
        String key = "";
        while ((menuLine = br.readLine()) != null) {
            
            if (isLineNewMenu(menuLine)){
                menuLine = removeLastChar(menuLine);
                key = menuLine;
            }
            else if (menuLine.isEmpty()){
                menuList.put(key, tempArray);
                tempArray = new ArrayList<>();
            }
            else{      
                tempArray.add(menuLine);
            }
        }
        
    }

    private void LoadMenuFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH + fileName))) {
            addMenuToMenuMap(br);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No file");
        }
    }

    public HashMap<String, ArrayList<String>> getMenuList(){
        return menuList;
    }

    public ArrayList<String> getSpecificMenu(String specificMenu){
        return menuList.get(specificMenu);
    }

    public void printMenu(String menuName) {
        for (String menu : allMenuList.getSpecificMenu(menuName)) {
            System.out.println(menu);
        }
    }

}