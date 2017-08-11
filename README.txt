Tại Server - Nơi có object cần gửi đi:
    import vn.vcc.adopt.server.sparkserver.*;

    SparkServer sparkServer = new SparkServer(); // Khởi tạo một đối tượng SparkServer
    SaveObject saveObj = new SaveObject(); // Khởi tạo một đối tượng SaveObject

     // gọi hàm saveObject(Object object, Class classname),
     //truyền vào object cần gửi đi và Class của object đó ví dụ:
    saveObj.saveObject(MapData.model, Model.class);

    // tạo cổng và lắng nghe request
    port(9999);
    get("/getdata", sparkServer);

Tại Client - Nơi cần nhận object:
    import vn.vcc.adopt.client.*;

    // Tạo một đối tượng ReceivedObject:
    // có thể dùng GetData.getData(url) để lấy dữ liệu
    ReceivedObject receivedObj = GetData.getData("http://localhost:9999/getdata");

    // có thể dùng GetData.getNewData(url) -
    // nếu có đối tượng mới hơn ở phía server thì trả về đối tượng đó
    // nếu không có đối tượng mới hơn thì trả về null
    ReceivedObject receivedObj = GetData.getNewData("http://localhost:9999/getdata");

    //Map data vào object cần dùng
    Model model = SerializationUtils.deserialize(receivedObj.getRawData());
