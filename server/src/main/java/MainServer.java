import commands.*;
import managers.ServerCommandManager;

import java.io.Console;


public class MainServer {
    public static void main(String[] args) {


        ServerCommandManager commandManager = new ServerCommandManager();

        commandManager.addCommands(new AbstractCommand[]{
                new HelpCommand(commandManager),
                new InfoCommand(),
                new ShowCommand(),
                new AddCommand(),
                new UpdateCommand(),
                new RemoveByIdCommand(),
                new ExitCommand(),
                new ExecuteScriptCommand(),
                new ClearCommand(),
                new PrintDescendingCommand(),
                new PrintUniqueLocationCommand(),
                new CountByHeightCommand(),
                new RemoveFirstCommand(),
        });
        new Thread(() -> {
            while (true) {
                Console console = System.console();
                String input;
                try {
                    input = console.readLine().trim();
                    if (input.equalsIgnoreCase("exit")) {
                        new ServerExitCommand().execute(null, null);
                    }
                }
                catch (NullPointerException e) {
                   System.out.println("Server is closing");
                }
            }
        }).start();


        Server server = new Server(Integer.parseInt(args[0]), commandManager);
        server.start();
        server.communicate();

    }
}
