import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class BotPloom extends TelegramLongPollingBot {

    private final static String ApiToken = "1047726751:AAE2-Y6hLAcYuccqNvTEzZNRKXm4hn1G6dc";
    private final static String BotName = "PloomBot";

    public static void main(String[] args) {
//        System.getProperties().put( "proxySet", "true" );
//        System.getProperties().put( "socksProxyHost", "204.48.19.184" );
//        System.getProperties().put( "socksProxyPort", "8080" );

        ApiContextInitializer.init();
        TelegramBotsApi botApi = new TelegramBotsApi();
        try {
            botApi.registerBot(new BotPloom());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMessage(update.getMessage().getChatId().toString(), message);
    }

    @Override
    public String getBotUsername() {
        return BotName;
    }

    @Override
    public String getBotToken() {
        return ApiToken;
    }

    public synchronized void sendMessage(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s + chatId);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
