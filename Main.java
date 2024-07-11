import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MyFile.help();
        Scanner in = new Scanner(System.in);
        String[] str = new String[3];
        int index;

        boolean exit = false;

        do {

            System.out.print("> ");
            index = 0;

            for (String line : in.nextLine().replaceAll(" ", "\n").lines().toList()) {
                if (line.length() == 0) {
                } else {
                    if (index <= 2) {
                        str[index] = line;
                    }
                    index++;
                }
            }

            if (!(str[0] == null)) {
                try {
                    switch (str[0]) {

                        case "ls":
                            MyFile.listDirectory(str[1]);
                            break;

                        case "ls_py":
                            MyFile.listPythonFiles(str[1]);
                            break;

                        case "is_dir":
                            MyFile.isDirectory(str[1]);
                            break;

                        case "define":
                            MyFile.define(str[1]);
                            break;

                        case "readmod":
                            MyFile.printPermissions(str[1]);
                            break;

                        case "setmod":
                            MyFile.setPermissions(str[1], str[2]);
                            break;

                        case "cat":
                            MyFile.printContent(str[1]);
                            break;

                        case "append":
                            MyFile.appendFooter(str[1]);
                            break;

                        case "bc":
                            MyFile.createBackup(str[1]);
                            break;

                        case "greplong":
                            MyFile.printLongestWord(str[1]);
                            break;

                        case "help":
                            MyFile.help();
                            break;

                        case "exit":
                            MyFile.exit();
                            exit = true;
                            break;

                        default:
                            System.out.println("Нет такой команды для отображения списка. Введите команду help");
                    }
                } catch (Exception e) {
                    if (str[0].equals("setmod")){
                        try {
                            if (!str[1].isEmpty()) {
                                System.out.println(str[0] + " " + str[1] + """
                         <perm пусто> или неверный Ввод
                        Для корректного ввода примеры ниже:
                        rwx :   полный доступ Read Write Execute;
                        r-- :   только Read;
                        -w- :   только Write;
                        --x :   только Execute;
                        --- :   полный запрет Read Write Execute;
                        rw- , r-x итд.
                        """);
                            }
                        }catch (Exception a){
                            System.out.println(a);
                            System.out.println(str[0] + " <path пусто>");
                        }
                    }else {
                        System.out.println(e);
                        System.out.println(str[0] + " <path пусто>");
                    }
                }
            }
            for (int i = 0; i < str.length; i++) {
                str[i] = null;
            }
        } while (!exit);
    }
}