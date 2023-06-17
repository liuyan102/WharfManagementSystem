package com.group.demo.service;

import com.group.demo.pojo.Delegation;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DelegationService {


    public List<Delegation> queryAll();
    public int add(Delegation delegation);
    public Delegation queryById(int DelegationID);
    public int delete(int DelegationID);
    public  int update(Delegation delegation);
}