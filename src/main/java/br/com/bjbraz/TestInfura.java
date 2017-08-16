package br.com.bjbraz;

import java.io.File;
import java.math.BigInteger;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.RawTransaction;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.infura.InfuraHttpService;
import org.web3j.protocol.parity.Parity;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

public class TestInfura {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String URL = "https://kovan.infura.io/lModPGEiDkYVit3TZxrr";
			Web3j web3 = Parity.build(new InfuraHttpService(URL));
			Credentials credentials = WalletUtils.loadCredentials("deltasp5k",
					"/home/asimas/.local/share/io.parity.ethereum/keys/kovan/UTC--2017-08-02T22-13-37Z--560d903d-14d5-a015-048f-754bfd5b8788");
			
			BigInteger value       = Convert.toWei("1.0", Convert.Unit.ETHER).toBigInteger();
			String from            = credentials.getAddress();
			
			final String senha     = "umaSenhaQualquerMasQueSoVoceSabe";
			final String diretorio = "/home/asimas/.local/share/io.parity.ethereum/keys/kovan/";
			String arquivoGerado   = criarCarteira(senha, diretorio);
			
			Credentials novaWallet  = WalletUtils.loadCredentials(senha, diretorio+arquivoGerado);
			String to              = novaWallet.getAddress();
			
			System.out.println(to);
			
			transferir(web3, from, to, credentials, value);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Cria uma nova wallet para você na rede, gerando o arquivo com a Private Key, de acordo com a senha que você passar.
	 */
	private static String criarCarteira(String senha, String diretorio) {
		try {
			String fileName = WalletUtils.generateNewWalletFile(
					senha,
			        new File(diretorio), true);
			System.out.println(fileName);
			return (fileName);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * Transfere um valor de uma conta para outra, utilizando as credenciais existentes.
	 */
	private static void transferir(Web3j web3, String from, String to, Credentials credentials, BigInteger value) {
		try {

			Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();
			String clientVersion = web3ClientVersion.getWeb3ClientVersion();
			System.out.println("Versão do Client : " + clientVersion);

			BigInteger nonce = getNonce(from, web3);
			BigInteger gasPrice = BigInteger.valueOf(20_000_000_000L);
			BigInteger gasLimit = BigInteger.valueOf(4_300_000);

			RawTransaction rawTransaction = RawTransaction.createEtherTransaction(nonce, gasPrice, gasLimit, to, value);

			byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
			String hexValue = Numeric.toHexString(signedMessage);

			EthSendTransaction ethSendTransaction = web3.ethSendRawTransaction(hexValue).sendAsync().get();
			String transactionHash = ethSendTransaction.getTransactionHash();

			EthGetTransactionReceipt transacao = web3.ethGetTransactionReceipt(transactionHash).sendAsync().get();
			System.out.println(transacao.getId());
			System.out.println(transacao.getJsonrpc());
			System.out.println(transactionHash);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param web3
	 */
	public static void getAccounts(Web3j web3) {
		try {
			EthAccounts contas = web3.ethAccounts().send();

			if (contas != null && contas.getAccounts() != null && contas.getAccounts().size() > 0) {
				for (String conta : contas.getAccounts()) {
					System.out.println(conta);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param address
	 * @return
	 * @throws Exception
	 */
	private static BigInteger getNonce(String address, Web3j web3) throws Exception {
		EthGetTransactionCount ethGetTransactionCount = web3
				.ethGetTransactionCount(address, DefaultBlockParameterName.LATEST).sendAsync().get();

		BigInteger nonce = ethGetTransactionCount.getTransactionCount();
		return nonce;
	}
}
