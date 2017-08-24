Tại Server - Nơi có object cần gửi đi:
    //Spark
        // Tạo một đối tượng Data
        Data data = new Data();

        // gọi hàm saveObject(Object object),
        //truyền vào đối tượng data vừa tạo và object cần gửi ví dụ:
        SaveObject.saveObject(data, MapData.model);

        // tạo cổng và lắng nghe request
        port(9999);
        head("/getdata",new SparkServer(data));
        get("/getdata",new SparkServer(data));


    //Rapidoid

        // Tạo một đối tượng Data
        Data data = new Data();

        
        //truyền vào đối tượng data vừa tạo và  object cần gửi đi ví dụ:
        SaveObject.saveObject(data, MapData.model);

        // tạo cổng và lắng nghe request
        On.port(9999);
        On.head("/getdata").plain(new RapidoidServer(data));
        On.get("/getdata").plain(new RapidoidServer(data));

Tại Client - Nơi cần nhận object:


    // nếu có đối tượng mới hơn ở phía server thì trả về đối tượng đó
    // nếu không có đối tượng mới hơn thì trả về null
    ReceivedObject receivedObj = GetData.getNewData("http://localhost:9999/getdata");

    //Map data vào object cần dùng
    Model model = SerializationUtils.deserialize(receivedObj.getData());
