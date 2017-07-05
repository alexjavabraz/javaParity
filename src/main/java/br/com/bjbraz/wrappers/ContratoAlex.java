package br.com.bjbraz.wrappers;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.2.1.
 */
public final class ContratoAlex extends Contract {
    private static final String BINARY = "6060604052341561000c57fe5b5b6108fe8061001c6000396000f300606060405236156100a15763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631838310e81146100a357806332970710146101565780635bfadae4146101e657806360fd1c4f1461020857806382fbdc9c1461026057806383197ef0146102c75780638cbec4f9146102d95780638da5cb5b146102ee5780639a64a27614610327578063e5d1bdc2146103b2575bfe5b34156100ab57fe5b6100b66004356103cc565b6040805160208101859052908101839052606081018290526080808252855460026000196101006001841615020190911604908201819052819060a0820190879080156101445780601f1061011957610100808354040283529160200191610144565b820191906000526020600020905b81548152906001019060200180831161012757829003601f168201915b50509550505050505060405180910390f35b341561015e57fe5b610166610403565b6040805160208082528351818301528351919283929083019185019080838382156101ac575b8051825260208311156101ac57601f19909201916020918201910161018c565b505050905090810190601f1680156101d85780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156101ee57fe5b6101f6610491565b60408051918252519081900360200190f35b341561021057fe5b61025e600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284375094965061049795505050505050565b005b6102ae600480803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437509496506104af95505050505050565b6040805192835260208301919091528051918290030190f35b34156102cf57fe5b61025e610534565b005b34156102e157fe5b61025e600435610576565b005b34156102f657fe5b6102fe6105b4565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b6101666004356105d0565b6040805160208082528351818301528351919283929083019185019080838382156101ac575b8051825260208311156101ac57601f19909201916020918201910161018c565b505050905090810190601f1680156101d85780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6101f66106e2565b60408051918252519081900360200190f35b60028054829081106103da57fe5b906000526020600020906004020160005b50600181015460028201546003830154929350909184565b6004805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156104895780601f1061045e57610100808354040283529160200191610489565b820191906000526020600020905b81548152906001019060200180831161046c57829003601f168201915b505050505081565b60035481565b80516104aa9060049060208401906106e8565b505b50565b600280544291600091600181016104c68382610767565b916000526020600020906004020160005b50604080516080810182528681526020808201869052918101869052436060820152865190929161050c9183918901906106e8565b506020820151816001015560408201518160020155606082015181600301555050505b915091565b6000543373ffffffffffffffffffffffffffffffffffffffff908116911614156105735760005473ffffffffffffffffffffffffffffffffffffffff16ff5b5b565b6000805473ffffffffffffffffffffffffffffffffffffffff19163373ffffffffffffffffffffffffffffffffffffffff1617905560018190555b50565b60005473ffffffffffffffffffffffffffffffffffffffff1681565b6105d8610818565b60005b6002548110156106ca57826002828154811015156105f557fe5b906000526020600020906004020160005b506001015414156106c157600280548290811061061f57fe5b906000526020600020906004020160005b50805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156106b55780601f1061068a576101008083540402835291602001916106b5565b820191906000526020600020905b81548152906001019060200180831161069857829003601f168201915b505050505091506106dc565b5b6001016105db565b60408051602081019091526000815291505b50919050565b60005b90565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061072957805160ff1916838001178555610756565b82800160010185558215610756579182015b8281111561075657825182559160200191906001019061073b565b5b5061076392915061082a565b5090565b81548183558181151161079357600402816004028360005260206000209182019101610793919061084b565b5b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061072957805160ff1916838001178555610756565b82800160010185558215610756579182015b8281111561075657825182559160200191906001019061073b565b5b5061076392915061082a565b5090565b60408051602081019091526000815290565b6106e591905b808211156107635760008155600101610830565b5090565b90565b6106e591905b80821115610763576000610865828261088a565b50600060018201819055600282018190556003820155600401610851565b5090565b90565b50805460018160011615610100020316600290046000825580601f106108b057506104ac565b601f0160209004906000526020600020908101906104ac919061082a565b5b505600a165627a7a723058208d8df60118080cde8767ac0a72889059e6db41574765a14aa4ed4fd7f65c5bd80029";

    private ContratoAlex(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private ContratoAlex(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public Future<List<Type>> itens(Uint256 param0) {
        Function function = new Function("itens", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<Utf8String> lastMessage() {
        Function function = new Function("lastMessage", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> numItems() {
        Function function = new Function("numItems", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> changeMessage(Utf8String _message) {
        Function function = new Function("changeMessage", Arrays.<Type>asList(_message), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> register(DynamicBytes _data) {
        Function function = new Function("register", Arrays.<Type>asList(_data), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> destroy() {
        Function function = new Function("destroy", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> Register(Bytes32 _name) {
        Function function = new Function("Register", Arrays.<Type>asList(_name), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Address> owner() {
        Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> findById(Uint256 x) {
        Function function = new Function("findById", Arrays.<Type>asList(x), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> itenQuantity() {
        Function function = new Function("itenQuantity", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public static Future<ContratoAlex> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(ContratoAlex.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<ContratoAlex> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(ContratoAlex.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static ContratoAlex load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ContratoAlex(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static ContratoAlex load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ContratoAlex(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
