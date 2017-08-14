package br.com.bjbraz;

import java.math.BigInteger;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.parity.Parity;

public class TestInfura {
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String URL = "https://kovan.infura.io/lModPGEiDkYVit3TZxrr";
	    Web3j web3    = Parity.build(new HttpService(URL));  // defaults to http://localhost:8545/

		try {
			
			Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();
			String clientVersion = web3ClientVersion.getWeb3ClientVersion();
			System.out.println("Versão do Client : " + clientVersion);
			
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
	private BigInteger getNonce(String address) throws Exception {
		Parity parity = Parity.build(new HttpService()); // defaults to
        EthGetTransactionCount ethGetTransactionCount = parity.ethGetTransactionCount(
                address, DefaultBlockParameterName.LATEST).sendAsync().get();
        return ethGetTransactionCount.getTransactionCount();
    }
}
