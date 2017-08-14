pragma solidity ^0.4.0;
contract Register {
    address public owner;
    bytes32 lastVersion;
    Item[] itens;
    uint numItems;
    
    struct Item {
        bytes data;
        uint id;
        uint hour;
        uint blockNumber;
    }
    
    
    function Register(bytes32 _name){
        owner       = msg.sender;
        lastVersion = _name;
    }
    
    /**
     * 
     **/
    function findById(uint x) public payable returns (bytes) {
        for (uint i = 0; i < itens.length; i++) {
             if (itens[i].id == x){
                 return itens[i].data;
             }
        }
        
        return '';
        
    }
    
    function itenQuantity() public payable returns (uint numItems){
        return numItems;
    }
    
    function register(bytes _data) public payable returns (uint timestamp, uint numItems){
        numItems = numItems++;
        timestamp = now;
        itens.push(Item(_data, numItems, timestamp, block.number));
    }
    
     function destroy() { // so funds not locked in contract forever
        if (msg.sender == owner) {
          suicide(owner); // send funds to organizer
        }
      }
    
    
}
