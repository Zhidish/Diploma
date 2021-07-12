package diploma.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;




@Configuration
public class WebSocketConfigSecurity  extends AbstractSecurityWebSocketMessageBrokerConfigurer {
        @Override
        protected void configureInbound(MessageSecurityMetadataSourceRegistry messages){

        messages
                .simpDestMatchers("/app/*").authenticated()
                .simpSubscribeDestMatchers("/topic/greetings").authenticated();

        }


        @Override
        protected boolean sameOriginDisabled(){
            return true;
        }



}
