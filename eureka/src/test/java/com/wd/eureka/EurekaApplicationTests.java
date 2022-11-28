package com.wd.eureka;

import org.docx4j.Docx4J;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class EurekaApplicationTests {

    public static void main(String[] args) throws Exception {

        wordToPdf();
    }

    //W:11906
    //H:16838
    public static void wordToPdf() throws Exception {
        try {
            WordprocessingMLPackage pkg = Docx4J.load(new File("D:\\收据模板.docx"));
//            SectPr sectPr = pkg.getDocumentModel().getSections().get(0).getSectPr();
//            SectPr.PgSz pgSz = sectPr.getPgSz();
//            pgSz.setW(new BigInteger("13606"));
//            pgSz.setH(new BigInteger("7937"));
            Mapper fontMapper = new IdentityPlusMapper();
            fontMapper.put("隶书", PhysicalFonts.get("LiSu"));
            fontMapper.put("宋体", PhysicalFonts.get("SimSun"));
            fontMapper.put("微软雅黑", PhysicalFonts.get("Microsoft Yahei"));
            fontMapper.put("黑体", PhysicalFonts.get("SimHei"));
            fontMapper.put("楷体", PhysicalFonts.get("KaiTi"));
            fontMapper.put("新宋体", PhysicalFonts.get("NSimSun"));
            fontMapper.put("华文行楷", PhysicalFonts.get("STXingkai"));
            fontMapper.put("华文仿宋", PhysicalFonts.get("STFangsong"));
            fontMapper.put("仿宋", PhysicalFonts.get("FangSong"));
            fontMapper.put("幼圆", PhysicalFonts.get("YouYuan"));
            fontMapper.put("华文宋体", PhysicalFonts.get("STSong"));
            fontMapper.put("华文中宋", PhysicalFonts.get("STZhongsong"));
            fontMapper.put("等线", PhysicalFonts.get("SimSun"));
            fontMapper.put("等线 Light", PhysicalFonts.get("SimSun"));
            fontMapper.put("华文琥珀", PhysicalFonts.get("STHupo"));
            fontMapper.put("华文隶书", PhysicalFonts.get("STLiti"));
            fontMapper.put("华文新魏", PhysicalFonts.get("STXinwei"));
            fontMapper.put("华文彩云", PhysicalFonts.get("STCaiyun"));
            fontMapper.put("方正姚体", PhysicalFonts.get("FZYaoti"));
            fontMapper.put("方正舒体", PhysicalFonts.get("FZShuTi"));
            fontMapper.put("华文细黑", PhysicalFonts.get("STXihei"));
            fontMapper.put("宋体扩展", PhysicalFonts.get("simsun-extB"));
            fontMapper.put("仿宋_GB2312", PhysicalFonts.get("FangSong_GB2312"));
            fontMapper.put("新細明體", PhysicalFonts.get("SimSun"));
            pkg.setFontMapper(fontMapper);

            Map<String, String> data = new HashMap<>();
            data.put("yearTime", "2022");
            data.put("mouthTime", "4");
            data.put("dayTime", "27");
            data.put("enterPrise", "杭州国美建筑设计研究院有限公司");
            data.put("payWay", "微信支付");
            data.put("moneyName", "肆万叁仟伍佰陆拾圆整");
            data.put("money", "43560.00");
            data.put("abstract", "1号楼1-9F  2022/04/01-2022/09/30 ");
            data.put("remark", "建行，杭州贝叶装饰设计有限公司建行");
            data.put("payee", "朱晓文");
            data.put("issuer", "张丹娜");
            data.put("issuingTime", "2022/03/16");
            // 设置模板
            MainDocumentPart documentPart = pkg.getMainDocumentPart();
            documentPart.variableReplace(data);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Docx4J.toPDF(pkg, outputStream);




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Docx4JException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
