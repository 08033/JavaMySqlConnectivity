public class Main{
    public static void main(String[] args) {
        Logger.PrintMessage("Hello world; MySql Connection Overview");
        Logger.PrintMessage("---------------------------------------");

        DataAccess dal = new DataAccess();
        dal.PrintCities();
    }
}