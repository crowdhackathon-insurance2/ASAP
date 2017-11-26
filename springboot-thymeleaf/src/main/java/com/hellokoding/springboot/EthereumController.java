package com.hellokoding.springboot;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.web3j.protocol.*;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.Ethereum;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetCode;
import org.web3j.protocol.core.methods.response.EthTransaction;
import org.web3j.protocol.http.HttpService;
import java.io.IOException;

@Controller
public class EthereumController {

    @RequestMapping("/balance")
    public String balance(Model model, @RequestParam(value="address", required=false, defaultValue="0xe1f0a3D696031E1F8ae7823581BB38C600aFF2BE") String address) throws IOException {


        Web3j web3 = Web3j.build(new HttpService("https://infuranet.infura.io/Cv9u2w3jnJWunoVolY80"));
        EthGetBalance web3ClientVersion = web3.ethGetBalance(address, DefaultBlockParameter.valueOf("latest")).send();
        String balance = web3ClientVersion.getBalance().toString();
        model.addAttribute("address", address);
        model.addAttribute("balance", balance);
        return "balance";
    }

    @RequestMapping("/balancePrivate")
    public String balancePrivate(Model model, @RequestParam(value="address", required=false, defaultValue="0x3e69d431f3f7c1ea51fcc1206b2b97f504c745ac") String address) throws IOException {


        Web3j web3 = Web3j.build(new HttpService("http://172.16.176.205:8545"));
        EthGetBalance web3ClientVersion = web3.ethGetBalance(address, DefaultBlockParameter.valueOf("latest")).send();
        String balance = web3ClientVersion.getBalance().toString();
        //web3.ethGetBlockByNumber(DefaultBlockParameter.valueOf("latest"), true).send().getBlock().getTransactions().get(0);
        model.addAttribute("address", address);
        model.addAttribute("balance", balance);
        return "balance";
    }

}