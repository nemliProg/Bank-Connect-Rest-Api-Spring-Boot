package ma.bankconnect.contoller;

import com.twilio.Twilio;
import ma.bankconnect.utils.TwilioUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
    TwilioUtil twilioUtil;

    @Autowired
    public MainController(TwilioUtil twilioUtil) {
        this.twilioUtil = twilioUtil;
    }

    @GetMapping("/")
    public String home() {
        twilioUtil.sendSMS("+212650257643", "Wa feen a lmangol .. ana taha rani khadamt Twilio l7abbek");
        return "Welcome to BankConnect";
    }
}
