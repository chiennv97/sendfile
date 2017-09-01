Version 4.1
Tại Server - Nơi có object cần gửi đi:
    //Spark
        // Tạo một đối tượng Data
        Data data = new Data();

        // gọi hàm saveObject(Object object),
        //truyền vào đối tượng data vừa tạo và 2 object cần gửi đi và tên ví dụ:
        SaveObject.saveObject(data, hashmap1, ""obj1", hashmap2, "obj2");

        // tạo cổng và lắng nghe request
        port(9999);
        head("/getdata",new SparkServer(data));
        get("/getdata",new SparkServer(data));



Tại Client - Nơi cần nhận object:


    // nếu có đối tượng mới hơn ở phía server thì trả về đối tượng đó
    // nếu không có đối tượng mới hơn thì trả về null
    ReceivedObject receivedObj = GetData.getNewData("http://localhost:9999/getdata");

    //Map data vào 2 object cần dùng
    HashMap model1 = SerializationUtils.deserialize(receivedObj.getObjByName("obj1"));
    HashMap model2 = SerializationUtils.deserialize(receivedObj.getObjByName("obj2"));
