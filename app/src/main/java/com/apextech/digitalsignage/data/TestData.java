package com.apextech.digitalsignage.data;

import com.apextech.digitalsignage.data.model.response.boughtleafdailylinecollectionsummary.BoughtLineSummaryData;
import com.apextech.digitalsignage.data.model.response.boughtleatdailyfactorycollectionsummary.BoughtFactorySummaryData;
import com.apextech.digitalsignage.data.model.response.divisionalgrossqty.DivisionData;
import com.apextech.digitalsignage.data.model.response.divisionalgrossqty.EstateData;
import com.apextech.digitalsignage.data.model.response.factorycollectonsummary.FactoryCollectionSummaryData;
import com.apextech.digitalsignage.data.model.response.interstateleafdailysummary.InterEstateLeafDailySummaryData;
import com.apextech.digitalsignage.data.model.response.weathernew.WeatherData;

import java.util.ArrayList;

public class TestData
{
    public TestData() {
    }

    public ArrayList<BoughtLineSummaryData> getLineSummaryList()
    {
        ArrayList<BoughtLineSummaryData>boughtLineSummaryDataArrayList = new ArrayList<>();

        BoughtLineSummaryData boughtLineSummaryData1 = new BoughtLineSummaryData();
        boughtLineSummaryData1.setEstate_id(1);
        boughtLineSummaryData1.setEstate_name("RAGALA ESTATE");
        boughtLineSummaryData1.setCollector_id(1111);
        boughtLineSummaryData1.setRoute("KANDY");
        boughtLineSummaryData1.setCollector_name("SAMAN");
        boughtLineSummaryData1.setCollected_quantities(125.36);

        BoughtLineSummaryData boughtLineSummaryData2 = new BoughtLineSummaryData();
        boughtLineSummaryData2.setEstate_id(1);
        boughtLineSummaryData2.setEstate_name("HIGH FOREST ESTATE");
        boughtLineSummaryData2.setCollector_id(2222);
        boughtLineSummaryData2.setRoute("GAMPOLA");
        boughtLineSummaryData2.setCollector_name("KAMAL");
        boughtLineSummaryData2.setCollected_quantities(122.76);

        BoughtLineSummaryData boughtLineSummaryData3 = new BoughtLineSummaryData();
        boughtLineSummaryData3.setEstate_id(1);
        boughtLineSummaryData3.setEstate_name("LIDDESDALE ESTATE");
        boughtLineSummaryData3.setCollector_id(3333);
        boughtLineSummaryData3.setRoute("NUWARA ELIYA");
        boughtLineSummaryData3.setCollector_name("NUWAN");
        boughtLineSummaryData3.setCollected_quantities(25.36);

        BoughtLineSummaryData boughtLineSummaryData4 = new BoughtLineSummaryData();
        boughtLineSummaryData4.setEstate_id(1);
        boughtLineSummaryData4.setEstate_name("GONAPITIYA");
        boughtLineSummaryData4.setCollector_id(4444);
        boughtLineSummaryData4.setRoute("KANDY");
        boughtLineSummaryData4.setCollector_name("TANUK");
        boughtLineSummaryData4.setCollected_quantities(225.36);

        boughtLineSummaryDataArrayList.add(boughtLineSummaryData1);
        boughtLineSummaryDataArrayList.add(boughtLineSummaryData2);
        boughtLineSummaryDataArrayList.add(boughtLineSummaryData3);
        boughtLineSummaryDataArrayList.add(boughtLineSummaryData4);

        return boughtLineSummaryDataArrayList;
    }

    public ArrayList<BoughtFactorySummaryData> getBoughtFactoryList()
    {
        ArrayList<BoughtFactorySummaryData> boughtFactorySummaryDataArrayList = new ArrayList<>();

        BoughtFactorySummaryData boughtFactorySummaryData1 = new BoughtFactorySummaryData();
        boughtFactorySummaryData1.setEstate_id(1);
        boughtFactorySummaryData1.setEstate_name("RAGALA");
        boughtFactorySummaryData1.setFactory_officer_name("SAMAN");
        boughtFactorySummaryData1.setSuppliers_count_processed(125.5);
        boughtFactorySummaryData1.setTotal_gross_weight_received(410.5);
        boughtFactorySummaryData1.setTotal_net_weight_received(400.25);

        BoughtFactorySummaryData boughtFactorySummaryData2 = new BoughtFactorySummaryData();
        boughtFactorySummaryData2.setEstate_id(2);
        boughtFactorySummaryData2.setEstate_name("HIGH");
        boughtFactorySummaryData2.setFactory_officer_name("NUWAN");
        boughtFactorySummaryData2.setSuppliers_count_processed(105.5);
        boughtFactorySummaryData2.setTotal_gross_weight_received(152.3);
        boughtFactorySummaryData2.setTotal_net_weight_received(125.45);

        BoughtFactorySummaryData boughtFactorySummaryData3 = new BoughtFactorySummaryData();
        boughtFactorySummaryData3.setEstate_id(3);
        boughtFactorySummaryData3.setEstate_name("LIDDESDALE");
        boughtFactorySummaryData3.setFactory_officer_name("PIYAL");
        boughtFactorySummaryData3.setSuppliers_count_processed(100.23);
        boughtFactorySummaryData3.setTotal_gross_weight_received(145.63);
        boughtFactorySummaryData3.setTotal_net_weight_received(52.6);

        BoughtFactorySummaryData boughtFactorySummaryData4 = new BoughtFactorySummaryData();
        boughtFactorySummaryData4.setEstate_id(4);
        boughtFactorySummaryData4.setEstate_name("GONAPITIYA");
        boughtFactorySummaryData4.setFactory_officer_name("LAHIRU");
        boughtFactorySummaryData4.setSuppliers_count_processed(259.3);
        boughtFactorySummaryData4.setTotal_gross_weight_received(300.25);
        boughtFactorySummaryData4.setTotal_net_weight_received(285.69);

        boughtFactorySummaryDataArrayList.add(boughtFactorySummaryData1);
        boughtFactorySummaryDataArrayList.add(boughtFactorySummaryData2);
        boughtFactorySummaryDataArrayList.add(boughtFactorySummaryData3);
        boughtFactorySummaryDataArrayList.add(boughtFactorySummaryData4);

        return boughtFactorySummaryDataArrayList;
    }

    public ArrayList<InterEstateLeafDailySummaryData> getInnerEstateLeafSummary()
    {
        ArrayList<InterEstateLeafDailySummaryData> innerEstateLeafDailySummaryDataList = new ArrayList<>();

        InterEstateLeafDailySummaryData innerEstateLeafDailySummaryData1 = new InterEstateLeafDailySummaryData();
        innerEstateLeafDailySummaryData1.setEstate_id(1);
        innerEstateLeafDailySummaryData1.setEstate_name("AAAAA");
        innerEstateLeafDailySummaryData1.setDestination("aaaaa");
        innerEstateLeafDailySummaryData1.setTotal_collected(456.69);
        innerEstateLeafDailySummaryData1.setDestination_confirm_received(458.25);

        InterEstateLeafDailySummaryData innerEstateLeafDailySummaryData2 = new InterEstateLeafDailySummaryData();
        innerEstateLeafDailySummaryData2.setEstate_id(2);
        innerEstateLeafDailySummaryData2.setEstate_name("BBBBBB");
        innerEstateLeafDailySummaryData2.setDestination("bbbbbb");
        innerEstateLeafDailySummaryData2.setTotal_collected(4589.36);
        innerEstateLeafDailySummaryData2.setDestination_confirm_received(4258.23);

        InterEstateLeafDailySummaryData innerEstateLeafDailySummaryData3 = new InterEstateLeafDailySummaryData();
        innerEstateLeafDailySummaryData3.setEstate_id(3);
        innerEstateLeafDailySummaryData3.setEstate_name("CCCCCC");
        innerEstateLeafDailySummaryData3.setDestination("cccccc");
        innerEstateLeafDailySummaryData3.setTotal_collected(569.52);
        innerEstateLeafDailySummaryData3.setDestination_confirm_received(520.36);

        InterEstateLeafDailySummaryData innerEstateLeafDailySummaryData4 = new InterEstateLeafDailySummaryData();
        innerEstateLeafDailySummaryData4.setEstate_id(4);
        innerEstateLeafDailySummaryData4.setEstate_name("DDDDDD");
        innerEstateLeafDailySummaryData4.setDestination("dddddd");
        innerEstateLeafDailySummaryData4.setTotal_collected(125.36);
        innerEstateLeafDailySummaryData4.setDestination_confirm_received(120.23);

        InterEstateLeafDailySummaryData innerEstateLeafDailySummaryData5 = new InterEstateLeafDailySummaryData();
        innerEstateLeafDailySummaryData5.setEstate_id(5);
        innerEstateLeafDailySummaryData5.setEstate_name("EEEEEE");
        innerEstateLeafDailySummaryData5.setDestination("eeeeee");
        innerEstateLeafDailySummaryData5.setTotal_collected(1245.36);
        innerEstateLeafDailySummaryData5.setDestination_confirm_received(1265.36);

        InterEstateLeafDailySummaryData innerEstateLeafDailySummaryData6 = new InterEstateLeafDailySummaryData();
        innerEstateLeafDailySummaryData6.setEstate_id(6);
        innerEstateLeafDailySummaryData6.setEstate_name("FFFFFF");
        innerEstateLeafDailySummaryData6.setDestination("ffffff");
        innerEstateLeafDailySummaryData6.setTotal_collected(259.36);
        innerEstateLeafDailySummaryData6.setDestination_confirm_received(263.23);

        InterEstateLeafDailySummaryData innerEstateLeafDailySummaryData7 = new InterEstateLeafDailySummaryData();
        innerEstateLeafDailySummaryData7.setEstate_id(7);
        innerEstateLeafDailySummaryData7.setEstate_name("GGGGGG");
        innerEstateLeafDailySummaryData7.setDestination("gggggg");
        innerEstateLeafDailySummaryData7.setTotal_collected(1025.6);
        innerEstateLeafDailySummaryData7.setDestination_confirm_received(1254.2);

        innerEstateLeafDailySummaryDataList.add(innerEstateLeafDailySummaryData1);
        innerEstateLeafDailySummaryDataList.add(innerEstateLeafDailySummaryData2);
        innerEstateLeafDailySummaryDataList.add(innerEstateLeafDailySummaryData3);
        innerEstateLeafDailySummaryDataList.add(innerEstateLeafDailySummaryData4);
        innerEstateLeafDailySummaryDataList.add(innerEstateLeafDailySummaryData5);
        innerEstateLeafDailySummaryDataList.add(innerEstateLeafDailySummaryData6);
        innerEstateLeafDailySummaryDataList.add(innerEstateLeafDailySummaryData7);

        return innerEstateLeafDailySummaryDataList;
    }

    public ArrayList<DivisionData> setEstate1DivisionsTestData()
    {
        DivisionData divisionData = new DivisionData();
        divisionData.setDivision_id(1);
        divisionData.setDivision_name("Halgranoya");
        divisionData.setGross_quantity_collected(1025.5);
        divisionData.setEstate_id(1);

        DivisionData divisionData1 = new DivisionData();
        divisionData1.setDivision_id(2);
        divisionData1.setDivision_name("Lower");
        divisionData1.setGross_quantity_collected(1075.5);
        divisionData.setEstate_id(1);

        DivisionData divisionData2 = new DivisionData();
        divisionData2.setDivision_id(3);
        divisionData2.setDivision_name("Middle");
        divisionData2.setGross_quantity_collected(1225.5);
        divisionData.setEstate_id(1);

        DivisionData divisionData3 = new DivisionData();
        divisionData3.setDivision_id(4);
        divisionData3.setDivision_name("Stafford");
        divisionData3.setGross_quantity_collected(1418.5);
        divisionData.setEstate_id(1);

        DivisionData divisionData4 = new DivisionData();
        divisionData4.setDivision_id(5);
        divisionData4.setDivision_name("Upper");
        divisionData4.setGross_quantity_collected(1529.5);
        divisionData.setEstate_id(1);

        ArrayList<DivisionData>divisionDataArrayList = new ArrayList<>();
        divisionDataArrayList.add(divisionData);
        divisionDataArrayList.add(divisionData1);
        divisionDataArrayList.add(divisionData2);
        divisionDataArrayList.add(divisionData3);
        divisionDataArrayList.add(divisionData4);

        return divisionDataArrayList;
    }

    public ArrayList<DivisionData> setEstate2DivisionsTestData()
    {
        DivisionData divisionData = new DivisionData();
        divisionData.setDivision_id(6);
        divisionData.setDivision_name("No 1");
        divisionData.setGross_quantity_collected(1025.5);
        divisionData.setEstate_id(2);

        DivisionData divisionData1 = new DivisionData();
        divisionData1.setDivision_id(7);
        divisionData1.setDivision_name("No 2");
        divisionData1.setGross_quantity_collected(1075.5);
        divisionData.setEstate_id(2);

        DivisionData divisionData2 = new DivisionData();
        divisionData2.setDivision_id(8);
        divisionData2.setDivision_name("No 3");
        divisionData2.setGross_quantity_collected(1225.5);
        divisionData.setEstate_id(2);

        ArrayList<DivisionData>divisionDataArrayList = new ArrayList<>();
        divisionDataArrayList.add(divisionData);
        divisionDataArrayList.add(divisionData1);
        divisionDataArrayList.add(divisionData2);

        return divisionDataArrayList;
    }

    public ArrayList<DivisionData> setEstate3DivisionsTestData()
    {
        DivisionData divisionData = new DivisionData();
        divisionData.setDivision_id(9);
        divisionData.setDivision_name("LDA");
        divisionData.setGross_quantity_collected(1025.5);
        divisionData.setEstate_id(3);

        DivisionData divisionData1 = new DivisionData();
        divisionData1.setDivision_id(10);
        divisionData1.setDivision_name("LDB");
        divisionData1.setGross_quantity_collected(1075.5);
        divisionData.setEstate_id(3);

        DivisionData divisionData2 = new DivisionData();
        divisionData2.setDivision_id(11);
        divisionData2.setDivision_name("Diyanilla");
        divisionData2.setGross_quantity_collected(1225.5);
        divisionData.setEstate_id(3);

        DivisionData divisionData3 = new DivisionData();
        divisionData3.setDivision_id(12);
        divisionData3.setDivision_name("Harasbedda");
        divisionData3.setGross_quantity_collected(1115.5);
        divisionData.setEstate_id(3);

        ArrayList<DivisionData>divisionDataArrayList = new ArrayList<>();
        divisionDataArrayList.add(divisionData);
        divisionDataArrayList.add(divisionData1);
        divisionDataArrayList.add(divisionData2);
        divisionDataArrayList.add(divisionData3);

        return divisionDataArrayList;
    }

    public ArrayList<DivisionData> setEstate4DivisionsTestData()
    {
        DivisionData divisionData = new DivisionData();
        divisionData.setDivision_id(13);
        divisionData.setDivision_name("Gonapitiya");
        divisionData.setGross_quantity_collected(1025.5);
        divisionData.setEstate_id(4);

        DivisionData divisionData1 = new DivisionData();
        divisionData1.setDivision_id(14);
        divisionData1.setDivision_name("Keenagolla");
        divisionData1.setGross_quantity_collected(1075.5);
        divisionData.setEstate_id(4);

        DivisionData divisionData2 = new DivisionData();
        divisionData2.setDivision_id(15);
        divisionData2.setDivision_name("Gonakelle");
        divisionData2.setGross_quantity_collected(1225.5);
        divisionData.setEstate_id(4);

        DivisionData divisionData3 = new DivisionData();
        divisionData3.setDivision_id(16);
        divisionData3.setDivision_name("Marigold Lower");
        divisionData3.setGross_quantity_collected(1115.5);
        divisionData.setEstate_id(4);

        DivisionData divisionData4 = new DivisionData();
        divisionData4.setDivision_id(17);
        divisionData4.setDivision_name("Marigold Upper");
        divisionData4.setGross_quantity_collected(1115.5);
        divisionData.setEstate_id(4);

        ArrayList<DivisionData>divisionDataArrayList = new ArrayList<>();
        divisionDataArrayList.add(divisionData);
        divisionDataArrayList.add(divisionData1);
        divisionDataArrayList.add(divisionData2);
        divisionDataArrayList.add(divisionData3);
        divisionDataArrayList.add(divisionData4);

        return divisionDataArrayList;
    }

    public ArrayList<DivisionData> setEstate6DivisionsTestData()
    {
        DivisionData divisionData = new DivisionData();
        divisionData.setDivision_id(18);
        divisionData.setDivision_name("Coneygar");
        divisionData.setGross_quantity_collected(1025.5);
        divisionData.setEstate_id(5);

        DivisionData divisionData1 = new DivisionData();
        divisionData1.setDivision_id(19);
        divisionData1.setDivision_name("Lower");
        divisionData1.setGross_quantity_collected(1075.5);
        divisionData.setEstate_id(5);

        DivisionData divisionData2 = new DivisionData();
        divisionData2.setDivision_id(20);
        divisionData2.setDivision_name("Upper");
        divisionData2.setGross_quantity_collected(1225.5);
        divisionData.setEstate_id(5);

        ArrayList<DivisionData>divisionDataArrayList = new ArrayList<>();
        divisionDataArrayList.add(divisionData);
        divisionDataArrayList.add(divisionData1);
        divisionDataArrayList.add(divisionData2);

        return divisionDataArrayList;
    }

    public ArrayList<DivisionData> setEstate5DivisionsTestData()
    {
        DivisionData divisionData = new DivisionData();
        divisionData.setDivision_id(21);
        divisionData.setDivision_name("Mahacoodagalla");
        divisionData.setGross_quantity_collected(1025.5);
        divisionData.setEstate_id(6);

        DivisionData divisionData1 = new DivisionData();
        divisionData1.setDivision_id(22);
        divisionData1.setDivision_name("Glendevon");
        divisionData1.setGross_quantity_collected(1075.5);
        divisionData.setEstate_id(6);

        ArrayList<DivisionData>divisionDataArrayList = new ArrayList<>();
        divisionDataArrayList.add(divisionData);
        divisionDataArrayList.add(divisionData1);

        return divisionDataArrayList;
    }

    public ArrayList<EstateData>setEstatesDataList()
    {
        EstateData estateData1 = new EstateData();
        estateData1.setEstate_id(1);
        estateData1.setEstate_name("RAGALA");
        estateData1.setTotal_gross(8456.5);
        //estateData1.setDivisions(setEstate1DivisionsTestData());

        EstateData estateData2 = new EstateData();
        estateData2.setEstate_id(2);
        estateData2.setEstate_name("HIGH FOREST");
        estateData2.setTotal_gross(2585.18);
        //estateData2.setDivisions(setEstate2DivisionsTestData());

        EstateData estateData3 = new EstateData();
        estateData3.setEstate_id(3);
        estateData3.setEstate_name("Liddesdale");
        estateData3.setTotal_gross(4475.25);
        //estateData3.setDivisions(setEstate3DivisionsTestData());

        EstateData estateData4 = new EstateData();
        estateData4.setEstate_id(4);
        estateData4.setEstate_name("Gonapitiya");
        estateData4.setTotal_gross(5896.13);
        //estateData4.setDivisions(setEstate4DivisionsTestData());

        EstateData estateData5 = new EstateData();
        estateData5.setEstate_id(5);
        estateData5.setEstate_name("Mahacoodagalla");
        estateData5.setTotal_gross(4758.00);
        //estateData5.setDivisions(setEstate5DivisionsTestData());

        EstateData estateData6 = new EstateData();
        estateData6.setEstate_id(6);
        estateData6.setEstate_name("St. Leonards");
        estateData6.setTotal_gross(4000.00);
        //estateData6.setDivisions(setEstate6DivisionsTestData());

        ArrayList<EstateData>list1 = new ArrayList<>();
        list1.add(estateData1);
        list1.add(estateData2);
        list1.add(estateData3);
        list1.add(estateData4);
        list1.add(estateData5);
        list1.add(estateData6);

        return list1;
    }
    public ArrayList<FactoryCollectionSummaryData> getFactoryCollectionDataList()
    {
        ArrayList<FactoryCollectionSummaryData>list = new ArrayList<>();

        FactoryCollectionSummaryData factoryCollectionSummaryData1 = new FactoryCollectionSummaryData();
        factoryCollectionSummaryData1.setEstate_id(1);
        factoryCollectionSummaryData1.setEstate_name("ABCD");
        factoryCollectionSummaryData1.setEstate_leaf(125.0);
        factoryCollectionSummaryData1.setInner_estate_leaf(145.2);
        factoryCollectionSummaryData1.setTotal_gross(150.3);
        factoryCollectionSummaryData1.setTotal_net(148.5);

        FactoryCollectionSummaryData factoryCollectionSummaryData2 = new FactoryCollectionSummaryData();
        factoryCollectionSummaryData2.setEstate_id(2);
        factoryCollectionSummaryData2.setEstate_name("PQRS");
        factoryCollectionSummaryData2.setEstate_leaf(105.0);
        factoryCollectionSummaryData2.setInner_estate_leaf(115.2);
        factoryCollectionSummaryData2.setTotal_gross(155.3);
        factoryCollectionSummaryData2.setTotal_net(128.5);

        FactoryCollectionSummaryData factoryCollectionSummaryData3 = new FactoryCollectionSummaryData();
        factoryCollectionSummaryData3.setEstate_id(3);
        factoryCollectionSummaryData3.setEstate_name("WXYZ");
        factoryCollectionSummaryData3.setEstate_leaf(225.0);
        factoryCollectionSummaryData3.setInner_estate_leaf(185.2);
        factoryCollectionSummaryData3.setTotal_gross(180.3);
        factoryCollectionSummaryData3.setTotal_net(189.5);

        FactoryCollectionSummaryData factoryCollectionSummaryData4 = new FactoryCollectionSummaryData();
        factoryCollectionSummaryData4.setEstate_id(4);
        factoryCollectionSummaryData4.setEstate_name("JKLM");
        factoryCollectionSummaryData4.setEstate_leaf(115.0);
        factoryCollectionSummaryData4.setInner_estate_leaf(115.2);
        factoryCollectionSummaryData4.setTotal_gross(110.3);
        factoryCollectionSummaryData4.setTotal_net(118.5);

        list.add(factoryCollectionSummaryData1);
        list.add(factoryCollectionSummaryData2);
        list.add(factoryCollectionSummaryData3);
        list.add(factoryCollectionSummaryData4);

        return list;
    }

    public ArrayList<WeatherData> getWeatherDataList()
    {
        ArrayList<WeatherData> mList = new ArrayList<>();

        WeatherData weatherData1 = new WeatherData();
        weatherData1.setDate("2023-05-24");
        weatherData1.setId(1);
        weatherData1.setMaximum_temp("32.05");
        weatherData1.setMinimum_temp("29.25");
        weatherData1.setWeather_condition("sunny");

        WeatherData weatherData2 = new WeatherData();
        weatherData1.setDate("2023-05-23");
        weatherData1.setId(2);
        weatherData1.setMaximum_temp("28.21");
        weatherData1.setMinimum_temp("26.55");
        weatherData1.setWeather_condition("rain");

        mList.add(weatherData1);
        mList.add(weatherData2);

        return mList;
    }
}
