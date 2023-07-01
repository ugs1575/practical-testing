package sample.cafekiosk.spring.api.service.mail;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import sample.cafekiosk.spring.client.mail.MailSendClient;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistory;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistoryRepository;

@ExtendWith(MockitoExtension.class)
class MailServiceTest {

	@Spy
	private MailSendClient mailSendClient;

	@Mock
	private MailSendHistoryRepository mailSendHistoryRepository;

	@InjectMocks
	private MailService mailService;

	@DisplayName("메일 전송 테스트")
	@Test
	void sendMail() {
	    //given
		// MailSendClient mailSendClient = Mockito.mock(MailSendClient.class);
		// MailSendHistoryRepository mailSendHistoryRepository = Mockito.mock(MailSendHistoryRepository.class);
		//
		// MailService mailService = new MailService(mailSendClient, mailSendHistoryRepository);

		// stubbing
		// when(mailSendClient.sendMail(
		// 	anyString(),
		// 	anyString(),
		// 	anyString(),
		// 	anyString()
		// )).thenReturn(true);

		//spy 사용시
		// doReturn(true)
		// 	.when(mailSendClient)
		// 	.sendMail(
		// 		anyString(),
		// 		anyString(),
		// 		anyString(),
		// 		anyString()
		// 	);

		BDDMockito.given(mailSendClient.sendMail(
			anyString(),
			anyString(),
			anyString(),
			anyString()
		)).willReturn(true);

		//when
		boolean result = mailService.sendMail("", "", "", "");

		//then
		assertThat(result).isTrue();
		Mockito.verify(mailSendHistoryRepository, times(1)).save(any(MailSendHistory.class));
	}

}