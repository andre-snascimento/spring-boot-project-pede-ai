package net.snascimento.pedeai;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PedeAiApplicationTests {

	@Test
	void contextLoads() {
		assertEquals("1", String.valueOf(1));
	}

}
