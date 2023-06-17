package com.group.demo;

import com.group.demo.pojo.*;
import com.group.demo.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    OwnerService ownerService;
    @Autowired
    EmployService employService;
    @Autowired
    ShipService shipService;
    @Autowired
    UnloadListService unloadListService;
    @Autowired
    ShipRegistryService shipRegistryService;
    @Autowired
    ContractService contractService;
    @Autowired
    InformService informService;
    @Autowired
    DelegationService delegationService;

    /*
        货主注册测试
     */
    @Test
    void ownerRegisterTest() {
        Owner owner = new Owner(7,"埃沙迪","aishadi",
                "123456","13648715984","aishadi@mail.com");
        int register = ownerService.register(owner);
        System.out.println(register);
    }

    /*
        货主登录测试
     */
    @Test
    void ownerLoginTest() {
        Owner owner = ownerService.login("zhangsan","123456");
        System.out.println(owner);
    }

    /*
        员工注册测试
     */
    @Test
    void employRegisterTest() {
        Employ employ = new Employ(6,"liu","123456", "刘",
                "男",20,"2001-12-02","13648715984",
                "aishadi@mail.com","船货代");
        int register = employService.register(employ);
        System.out.println(register);
    }

    /*
        员工登录测试
     */
    @Test
    void employLoginTest() {
        Employ employ = employService.login("wangwu","456789");
        System.out.println(employ);
    }

    /*
        新建船舶信息测试
     */
    @Test
    void addShipTest(){
        Ship ship = new Ship(3,2,"刘","13648715984","铁矿石",
                "2021-06-30","2021-07-01","海南","未指派","无");
        int add = shipService.add(ship);
        System.out.println(add);
    }

    /*
        编辑船舶信息测试
     */
    @Test
    void updateShipTest(){
        Ship ship = new Ship(3,2,"刘","13648715984","铁矿石",
                "2021-05-30","2021-06-01","海南","未指派","无");
        int update = shipService.update(ship);
        System.out.println(update);
    }

    /*
        删除船舶信息测试
     */
    @Test
    void deleteShipTest(){
        int delete = shipService.delete(3);
        System.out.println(delete);
    }

    /*
        获取船舶信息测试
     */
    @Test
    void getAllShipTest(){
        List<Ship> shipList = shipService.getAll();
        System.out.println(shipList);
    }

    /*
        新建卸货清单测试
     */
    @Test
    void addUnloadListTest(){
        UnloadList unloadList = new UnloadList(11,3,3,3,
                "王鹏飞","15031818005","铁矿石","2000-1-1",
                "秦皇岛","123456");
        int add = unloadListService.add(unloadList);
        System.out.println(add);
    }

    /*
        编辑卸货清单测试
     */
    @Test
    void  updateUnloadListTest(){
        UnloadList unloadList = new UnloadList(11,3,3,3,
                "王鹏飞","15031818005","铁矿石","2000-1-1",
                "海南","123456");
        int update = unloadListService.update(unloadList);
        System.out.println(update);
    }

    /*
        获取卸货清单测试
     */
    @Test
    void getAllUnloadListTest(){
        List<UnloadList> unloadLists= unloadListService.getAll();
        System.out.println(unloadLists);
    }

    /*
        新建单船登记帐测试
     */
    @Test
    void addShipRegistryTest(){
        ShipRegistry shipRegistry = new ShipRegistry(4,"2021-06-10",3,
                3, "1489646","2123","大型货船",10,"张三",
                "13935648066", "钱七","13649485644","12345687");
        int add = shipRegistryService.add(shipRegistry);
        System.out.println(add);
    }

    /*
        编辑单船登记帐测试
     */
    @Test
    void updateShipRegistryTest(){
        ShipRegistry shipRegistry = new ShipRegistry(4,"2021-06-10",3,
                3, "1489646","2025-5-30","大型货船",10,"张三",
                "13935648066", "钱七","13649485644","12345687");
        int update = shipRegistryService.update(shipRegistry);
        System.out.println(update);
    }

    /*
        获取单船登记帐测试
     */
    @Test
    void getAllShipRegistryTest(){
        List<ShipRegistry> shipRegistryList = shipRegistryService.queryAll();
        System.out.println(shipRegistryList);
    }

    /*
        新建单船作业计划通知单
     */
    @Test
    void addInformTest(){
        Inform inform = new Inform(4,"2021-06-10",3,3,
                "刘","156154556484","铁矿石",10,
                "2021-06-13","无");
        int add = informService.add(inform);
        System.out.println(add);
    }

    /*
        编辑单船作业计划通知单
     */
    @Test
    void updateInformTest(){
        Inform inform = new Inform(1,"2021-06-10",1,1,
                "张三","156154556484","铁矿石",10,
                "2021-06-13","无");
        int update = informService.update(inform);
        System.out.println(update);
    }

    /*
        获取单船作业计划通知单
     */
    @Test
    void getAllInformTest(){
        List<Inform> informList = informService.queryAll();
        System.out.println(informList);
    }

    /*
        新建装卸合同测试
     */
    @Test
    void addContractTest(){
        Contract contract = new Contract(3,"营口港码头卸货合同","营口港口集团投资有限公司","哈斯卡",
                "13946851365","营口","海南铁矿有限公司","刘","12345678910","海南","按《合同法》相关规定执行。",
                "甲方责任和义务: 1、甲方应该根据乙方提供的到港信息合理调度，安排船舶进出港作业; 2、接到乙方作业申请后，积极做好接卸货物的各项准备工作; 3、甲方不参与货物的交接与管理,与货运质量和交接数量无关，只对卸船过程负责; 乙方责任和义务: 1、乙方应当提前3天将船舶名称、到港时间、离港时间及船舶基本信息等报告甲方; 2、乙方在船舶靠泊前办妥《港口作业委托单》及其他有关手续; 3、乙方应当如实告知所卸物件的特性和必须采取措施等需要注意的事项; 4、乙方负责进口货物监管监卸工作，发现问题及时与甲方协调处理。",
                "2021-06-16","2021-06-17","2021-06-20","无");
        int add = contractService.add(contract);
        System.out.println(add);
    }

    /*
        获取装卸合同测试
     */
    @Test
    void getAllContractTest(){
        List<Contract> contracts = contractService.queryAll();
        System.out.println(contracts);
    }

    /*
        编辑装卸合同测试
     */
    @Test
    void updateContractTest(){
        Contract contract = new Contract(3,"营口港码头卸货合同","营口港口集团投资有限公司","哈斯卡",
                "13946851365","营口","海南铁矿有限公司","王","12345678910","海南","按《合同法》相关规定执行。",
                "甲方责任和义务: 1、甲方应该根据乙方提供的到港信息合理调度，安排船舶进出港作业; 2、接到乙方作业申请后，积极做好接卸货物的各项准备工作; 3、甲方不参与货物的交接与管理,与货运质量和交接数量无关，只对卸船过程负责; 乙方责任和义务: 1、乙方应当提前3天将船舶名称、到港时间、离港时间及船舶基本信息等报告甲方; 2、乙方在船舶靠泊前办妥《港口作业委托单》及其他有关手续; 3、乙方应当如实告知所卸物件的特性和必须采取措施等需要注意的事项; 4、乙方负责进口货物监管监卸工作，发现问题及时与甲方协调处理。",
                "2021-06-16","2021-06-17","2021-06-20","无");
        int update = contractService.update(contract);
        System.out.println(update);
    }

    /*

     */
}
