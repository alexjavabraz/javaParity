package br.com.bjbraz;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.concurrent.ExecutionException;

import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

public class Connection {
	
	public static void main(String[] args) {
		
		try {
			
			Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:8545"));
			
			Credentials credentials = WalletUtils.loadCredentials("deltasp5k", "/home/alexjavabraz/.local/share/io.parity.ethereum/keys/kovan/UTC--2017-05-23T22-31-59Z--f2a250aa-3694-0526-e8ef-8fd4aad864ae");
			
			BigInteger gasPrice = BigInteger.valueOf(20_000_000_000L);
			BigInteger gasLimit = BigInteger.valueOf(4_300_000);
			
			Register register = Register.load("0x61fE0e3d6D9305F01ca1fb0f379F382d312211FE", web3, credentials, gasPrice, gasLimit);
			
			TransactionReceipt transactionReceipt = register.register(new DynamicBytes("0x61fE0e3d6Dcdascdsacascdascdascda9305F01ca1fb0f379F382d312211FE".getBytes())).get();
			//TransactionReceipt transactionReceipt = register.itenQuantity().get();
			System.out.println(transactionReceipt.getTransactionHash());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CipherException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
