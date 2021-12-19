<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Fill in form</title>
</head>
<body>
<div STYLE="text-align: center">
    <h3>TỜ KHAI Y TẾ</h3>
    <h4>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ ...</h4>
    <h4 style="color: red">Khuyến cáo ...</h4>
</div>
<div class="container">
    <form:form action="/showInfo" method="post" modelAttribute="medicalDeclaration" class="row g-3">
        <div class="col-12">
            <form:label path="name" class="form-label">Họ tên (ghi chữ IN HOA)</form:label>
            <form:input type="text" path="name" class="form-control" placeholder="name"/>
        </div>
        <div class="col-md-4">
            <form:label path="birthday" class="form-label">Năm sinh</form:label>
            <form:input type="text" path="birthday" class="form-control" placeholder="birthday"/>
        </div>
        <div class="col-md-4">
            <form:label path="gender" class="form-label">Giới tính</form:label>
            <form:select path="gender">
                <form:option value="Male">Male</form:option>
                <form:option value="Female">Female</form:option>
                <form:option value="Other">Other</form:option>
            </form:select>
        </div>
        <div class="col-md-4">
            <form:label path="national" class="form-label">Quốc tịch</form:label>
            <form:select path="national">
                <form:options items="${nationals}"></form:options>
            </form:select>
        </div>
        <div class="col-12">
            <form:label path="idCard" class="form-label">Số hộ chiếu hoặc số CMND</form:label>
            <form:input type="text" path="idCard" class="form-control" placeholder="Id Card"/>
        </div>
        <div class="col-12">
            <label class="form-label">Thông tin đi lại</label>
            <table>
                <tr>
                    <td>
                        <div class="col-3">
                            <form:label path="travelInfo" class="form-label">Tàu bay</form:label>
                            <form:radiobutton path="travelInfo" value="Flight"/>
                        </div>
                    </td>
                    <td>
                        <div class="col-3">
                            <form:label path="travelInfo" class="form-label">Tàu thuyền</form:label>
                            <form:radiobutton path="travelInfo" value="Ship"/>
                        </div>
                    </td>
                    <td>
                        <div class="col-3">
                            <form:label path="travelInfo" class="form-label">Ô tô</form:label>
                            <form:radiobutton path="travelInfo" value="Car"/>
                        </div>
                    </td>
                    <td>
                        <div class="col-3">
                            <form:label path="travelInfo" class="form-label">Khác( Ghi rõ)</form:label>
                            <form:radiobutton path="travelInfo" value="Other"/>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <div class="col-md-6">
            <form:label path="idVehicle" class="form-label">Số hiệu phương tiện</form:label>
            <form:input path="idVehicle" type="text" class="form-control"/>
        </div>
        <div class="col-md-6">
            <form:label path="idSeat" class="form-label">Sô ghế</form:label>
            <form:input path="idSeat" type="text" class="form-control"/>
        </div>
        <div class="col-md-6">
            <form:label path="startDay" class="form-label">Ngày khởi hành</form:label>
            <form:input path="startDay" type="date" class="form-control"/>
        </div>
        <div class="col-md-6">
            <form:label path="endDay" class="form-label">Ngày kết thúc</form:label>
            <form:input path="endDay" type="date" class="form-control"/>
        </div>
        <div class="col-12">
            <form:label path="localArrive" class="form-label">Trong 14 ngày qua, anh/chị có đến tỉnh/TP nào?</form:label>
            <form:textarea path="localArrive" class="form-control"/>
        </div>
        <div class="col-12">
            <label class="form-label">Đại chỉ liên lạc</label>
        </div>

        <div class="col-12">
            <table>
                <tr>
                    <td>
                        <div class="col-3">
                            <form:label path="city" class="form-label">Tỉnh/Thành</form:label>
                            <form:select path="city">
                                <form:options items="${cities}"></form:options>
                            </form:select>

                        </div>
                    </td>
                    <td>
                        <div class="col-3">
                            <form:label path="district" class="form-label">Quận/Huyện</form:label>
                            <form:select path="district">
                                <form:options items="${districts}"></form:options>
                            </form:select>
                        </div>
                    </td>
                    <td>
                        <div class="col-3">
                            <form:label path="ward" class="form-label">Phường/Xã</form:label>
                            <form:select path="ward">
                                <form:options items="${wards}"></form:options>
                            </form:select>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <div class="col-md-6">
            <form:label path="phone" class="form-label">Số điện thoại</form:label>
            <form:input path="phone" class="form-control"/>
        </div>
        <div class="col-md-6">
            <form:label path="email" class="form-label">Email</form:label>
            <form:input path="email" class="form-control"/>
        </div>
        <div class="col-12">
            <label path="localArrive" class="form-label">Trong 14 ngày qua, anh/chị có xuất hiện dấu hiệu nào sau đây ko?</label>
            <table class="col-12" border="1">
                <tr>
                    <td><form:label path="fever" class="form-label">Sốt</form:label></td>
                    <td><form:radiobuttons path="fever" items="${choices}"/></td>
                </tr>
                <tr>
                    <td><form:label path="cough" class="form-label">Ho</form:label></td>
                    <td><form:radiobuttons path="cough" items="${choices}"/></td>
                </tr>
                <tr>
                    <td><form:label path="nausea" class="form-label">Khó thở</form:label></td>
                    <td><form:radiobuttons path="nausea" items="${choices}"/></td>
                </tr>
                <tr>
                    <td><form:label path="diarrhea" class="form-label">Đau họng</form:label></td>
                    <td><form:radiobuttons path="diarrhea" items="${choices}"/></td>
                </tr>

            </table>
        </div>
        <div class="col-12">
            <label class="form-label">Lịch sử phơi nhiễm: Trong 14 ngày qua a/c có</label>

            <table class="col-12" border="1">
                <tr>
                    <td><form:label path="history1" class="form-label">Đến trại chăn nuôi/...</form:label></td>
                    <td><form:radiobuttons path="history1" items="${choices}"/></td>
                </tr>
                <tr>
                    <td><form:label path="history1" class="form-label">Tiếp xúc gần ...</form:label></td>
                    <td><form:radiobuttons path="history2" items="${choices}"/></td>
                </tr>
            </table>
        </div>
        <div>
            <p style="color: red">Dữ liệu bạn cung cấp .... đồng ý.</p>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Gởi tờ khai</button>
        </div>
    </form:form>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</div>
</body>
</html>
