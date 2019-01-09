package cn.chunhuitech.www.api.admin.controller.web;

import cn.chunhuitech.www.api.admin.model.CommRecordSearchBo;
import cn.chunhuitech.www.api.admin.model.CommRecordWebSearchBo;
import cn.chunhuitech.www.api.admin.service.CommRecordService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPageModel;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommRecord;
import cn.chunhuitech.www.core.common.annotation.Skip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hechengjin on 17-9-29.
 */
@RestController
@RequestMapping(value = "/web/page")
public class CommRecordPageController {


    @Autowired
    private CommRecordService commRecordService;


    @Skip
    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommRecordSearchBo> search(@RequestBody CommRecordPara commRecordPara) throws Exception{
        return commRecordService.getList(commRecordPara);
    }

    @Skip
    @RequestMapping(value = "/search2", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommRecordWebSearchBo> search2(@RequestBody CommRecordPara commRecordPara) throws Exception{
        return commRecordService.getList2(commRecordPara);
    }


    @Skip
    @RequestMapping(value = "/addPage", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage addPage(@RequestBody CommRecordPageModel commRecordPageModel) throws Exception{
        return commRecordService.addPage(commRecordPageModel);
    }

    @Skip
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage add(@RequestBody CommRecord commRecord) throws Exception{
        return commRecordService.add(commRecord);
    }

    @Skip
    @RequestMapping(value = "/modPage", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage modPage(@RequestBody CommRecordPageModel commRecordPageModel) throws Exception{
        return commRecordService.modPage(commRecordPageModel);
    }

    @Skip
    @RequestMapping(value = "/mod", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage mod(@RequestBody CommRecord commRecord) throws Exception{
        return commRecordService.mod(commRecord);
    }

    @Skip
    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage del(@RequestBody CommRecordPara commRecordPara) throws Exception{
        return commRecordService.del(commRecordPara);
    }

}
