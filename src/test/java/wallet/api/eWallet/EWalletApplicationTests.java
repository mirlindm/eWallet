package wallet.api.eWallet;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import wallet.api.eWallet.domain.model.Transaction;
import wallet.api.eWallet.domain.model.eWallet;
import wallet.api.eWallet.rest.eWalletRestController;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(eWalletRestController.class)
class EWalletApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private eWalletRestController walletRestController;

	@Test
	void contextLoads() {
	}

	@Test
	public void createWallet() throws Exception {

		given(walletRestController.createWallet()).willReturn(new ResponseEntity<eWallet>);

		mockMvc.perform(post("/eWallet/wallets"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("response").value("Wallet successfully created!"));
	}

	@Test
	public void fetchWalletById() throws Exception {

		given(walletRestController.getWalletById(1L)).willReturn(new ResponseEntity<eWallet>);

		mockMvc.perform(get("/eWallet/1"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
	}

	@Test
	public void fetchListOfWallets() throws Exception {

		given(walletRestController.getAllWallets()).willReturn(new List<eWallet>);

		mockMvc.perform(get("/eWallet"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
	}

	@Test
	public void createTransaction() throws Exception {

		given(walletRestController.createTransaction(new Transaction())).willReturn(new ResponseEntity<Transaction>);

		mockMvc.perform(post("/eWallet/transactions"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
	}

}
