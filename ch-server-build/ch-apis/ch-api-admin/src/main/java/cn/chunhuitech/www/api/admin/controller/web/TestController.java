package cn.chunhuitech.www.api.admin.controller.web;

import cn.chunhuitech.www.api.admin.model.AdminUserInfoBo;
import cn.chunhuitech.www.api.admin.model.AdminUserLoginBo;
import cn.chunhuitech.www.api.admin.service.AdminUserService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hechengjin on 17-9-29.
 */
@RestController
@RequestMapping(value = "/web/test")
public class TestController {

    @RequestMapping(value = "/table/list", method = RequestMethod.GET, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result list() throws Exception{
        class ItemData {
            String id;
            String title;
            String status;
            String author;
            String display_time;
            Integer pageviews;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getDisplay_time() {
                return display_time;
            }

            public void setDisplay_time(String display_time) {
                this.display_time = display_time;
            }

            public Integer getPageviews() {
                return pageviews;
            }

            public void setPageviews(Integer pageviews) {
                this.pageviews = pageviews;
            }
        }

        class TableData {
            private List<ItemData> items;

            public List<ItemData> getItems() {
                return items;
            }

            public void setItems(List<ItemData> items) {
                this.items = items;
            }
        }
        TableData tableData = new TableData();
        List<ItemData> items = new ArrayList<>();
        ItemData itemData1 = new ItemData();
        itemData1.setId("140000198808226262");
        itemData1.setTitle("Mymb hxiwpj fhjwgnnpn yahl acpgrlpue pbsnraw fnooir yxrvv widm cgiinhpl paeecqv wqtbv rvejiitifw dwplygd bklcbonywe dtblefo ptruomblbd afjihogcc nfbof.");
        itemData1.setStatus("draft");
        itemData1.setAuthor("name");
        itemData1.setDisplay_time("1982-10-12 01:03:22");
        itemData1.setPageviews(3880);
        items.add(itemData1);
        ItemData itemData2 = new ItemData();
        itemData2.setId("450000197707261585");
        itemData2.setTitle("Vyvqbfwn bumwyvbcxx hzij xjanupwyfn lwtrsk bovpmqma cdjjyxckq pktu bcppsfosfr pchfmkowvj gpprirmq ddrvv oyzitdjvys.");
        itemData2.setStatus("draft");
        itemData2.setAuthor("name");
        itemData2.setDisplay_time("1976-02-08 05:25:20");
        itemData2.setPageviews(4613);
        items.add(itemData2);
        tableData.setItems(items);
        return new Result<>(tableData);
    }

}
