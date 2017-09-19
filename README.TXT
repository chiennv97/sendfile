Version 4.2.1 - Add Rapidoid
Tại Server - Nơi có object cần gửi đi:

        // Tạo một đối tượng Data
        Data data = new Data();

        // Lưu data vừa tạo
        SaveObject.saveData(data);

        // Lưu các object cần gửi đi - ví dụ gửi 2 0bject đi
        SaveObject.saveObject("a", MapData.model);
        SaveObject.saveObject("b", hashmap1);

        // Lưu thời gian
   		SaveObject.saveLastModified();

        // tạo cổng và lắng nghe request
            //Spark
            port(9999);
            head("/getdata",new SparkServer(data));
            get("/getdata",new SparkServer(data));

            //Rapidoid
            On.port(9999);
            On.head("/getdata").plain(new RapidoidServer(data));
            On.get("/getdata").plain(new RapidoidServer(data));

        // Thay đổi object cần gửi đi
            SaveObject.saveObject("a", MapData.model);
            SaveObject.saveObject("b", hashmap1);

            // Lưu lại thời gian
            SaveObject.saveLastModified();

        // Xóa object đã lưu vào đối tượng data
            SaveObject.removeOjbectByName("a");
            // hoặc
            SaveObject.removeAllObject();


Tại Client - Nơi cần nhận object:


    // nếu có đối tượng mới hơn ở phía server thì trả về đối tượng đó
    // nếu không có đối tượng mới hơn thì trả về null
    ListReceivedObject listReceivedObj = GetData.getNewData("http://localhost:9999/getdata");

    //Map data vào 2 object cần dùng
    if(listReceivedObj.getListData().get("a")!= null){
        Model model1 = SerializationUtils.deserialize(listReceivedObj.getListData().get("a").getData());
    }
    if(listReceivedObj.getListData().get("b")!= null) {
        HashMap model2 = SerializationUtils.deserialize(listReceivedObj.getListData().get("b").getData());
    }