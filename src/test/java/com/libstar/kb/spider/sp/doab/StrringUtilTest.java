package com.libstar.kb.spider.sp.doab;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 李增光
 * @create 2018-08-09 19:55
 **/
public class StrringUtilTest {

    public static void main(String[] args) {
        test1();
    }

    public static String str1 = "Be true to yourself and everything will be fine.做真实的自己，一切都会好起来的。";
    public static String str2 = "Be true to yourself and everything will be fine.做真实的自己，一切都会好起来的。";
    public static String str3 = "Worrying does not take away tomorrow's troubles, it takes away today's peace";
    public static String str4 = "0123456789";
    public static String str5 = "ABCD";
    public static String str6 = "abcd";

    public static String text = "重要地位\n" +
            "\n" +
            "　　是习近平新时代中国特色社会主义思想的重要组成部分；\n" +
            "\n" +
            "　　是马克思主义基本原理同中国特色大国外交实践相结合的重大理论结晶；\n" +
            "\n" +
            "　　是以习近平同志为核心的党中央治国理政思想在外交领域的集中体现；\n" +
            "\n" +
            "　　是新时代我国对外工作的根本遵循和行动指南。\n" +
            "\n" +
            "　　重中之重： “十个坚持”为其总体框架和核心要义\n" +
            "\n" +
            "　　一是坚持以维护党中央权威为统领加强党对对外工作的集中统一领导。这是做好对外工作的根本保证。\n" +
            "\n" +
            "　　二是坚持以实现中华民族伟大复兴为使命推进中国特色大国外交。这是新时代赋予对外工作的历史使命。\n" +
            "\n" +
            "　　三是坚持以维护世界和平、促进共同发展为宗旨推动构建人类命运共同体。这是新时代对外工作的总目标。\n" +
            "\n" +
            "　　四是坚持以中国特色社会主义为根本增强战略自信。这是新时代对外工作必须遵循的根本要求。\n" +
            "\n" +
            "　　五是坚持以共商共建共享为原则推动“一带一路”建设。这是我国今后相当长时期对外开放和对外合作的管总规划，也是人类命运共同体理念的重要实践平台。\n" +
            "\n" +
            "　　六是坚持以相互尊重、合作共赢为基础走和平发展道路。这是中国外交必须长期坚持的基本原则。\n" +
            "\n" +
            "　　七是坚持以深化外交布局为依托打造全球伙伴关系。这是新时代中国外交的重要内涵。\n" +
            "\n" +
            "　　八是坚持以公平正义为理念引领全球治理体系改革。这是新时代中国外交的重要努力方向。\n" +
            "\n" +
            "　　九是坚持以国家核心利益为底线维护国家主权、安全、发展利益。这是对外工作的出发点和落脚点。\n" +
            "\n" +
            "　　十是坚持以对外工作优良传统和时代特征相结合为方向塑造中国外交独特风范。这是中国外交的精神标识。\n" +
            "\n" +
            "　　学习这一思想，可深入领会以下4点：\n" +
            "\n" +
            "　　1. 要准确把握新时代中国和世界发展大势。 习近平总书记强调，把握国际形势要树立正确的历史观、大局观、角色观。\n" +
            "\n" +
            "　　2. 要切实做好历史交汇期的对外工作。 习近平总书记指出，从党的十九大到党的二十大，是实现“两个一百年”奋斗目标的历史交汇期，在中华民族伟大复兴历史进程中具有特殊重大意义。\n" +
            "\n" +
            "　　3. 要坚决贯彻党中央对对外工作的战略部署。\n" +
            "\n" +
            "　　4. 要不断强化党对对外工作的集中统一领导。\n" +
            "\n" +
            "　　如何学懂弄通做实？\n" +
            "\n" +
            "　　1. 提高政治站位，进一步用习近平外交思想武装头脑。\n" +
            "\n" +
            "　　2. 围绕重大活动，进一步推动对外工作更好服务国家发展和民族复兴。\n" +
            "\n" +
            "　　3. 勇于开拓进取，进一步增强外交工作主动性创造性。\n" +
            "\n" +
            "　　4. 强化队伍建设，进一步提高对外工作能力和水平。\n" +
            "\n" +
            "　　5. 狠抓贯彻落实，进一步确保党中央的战略部署落到实处。\n" +
            "\n" +
            "责任编辑：高原\n" +
            "首页 | 上一页 1 下一页 | 尾页 \n" +
            "相关时政新闻\n" +
            "习近平强军思想的理论要义\n" +
            "“强军强什么？怎么样强军？”这是时代抛给我们的重大命题。作为曾经的军转干部，如今的军委...\n" +
            "\n" +
            "2018-08-09 12:29:00\n" +
            "自习课丨重温习近平总书记的全民健身寄语\n" +
            "2018年2月7日，孩子们在江西省铜鼓县七星岭滑雪场进行滑雪接龙趣味训练。新华社记者万象摄201...\n" +
            "\n" +
            "2018-08-09 12:27:00\n" +
            "踏平坎坷成大道\n" +
            "一个中华儿女无比自豪、永远铭记的日子。十年前，北京奥运会隆重开幕，实现了中华民族的百年...\n" +
            "\n" +
            "2018-08-09 10:43:00\n" +
            "习近平时间|为根治“地球的癌症”开出“中国药方”\n" +
            "荒漠化被称为“地球的癌症”，是全球生态领域的热点和难点问题。中共十八大以来，中国大力推...\n" +
            "\n" +
            "2018-08-09 10:27:00\n" +
            "习近平眼中“大党的样子”\n" +
            "习近平总书记在十九届中共中央政治局常委同中外记者见面以及在中国共产党与世界政党高层对话...\n" +
            "\n" +
            "2018-08-09 10:26:00\n" +
            "习近平：千秋基业 人才为本\n" +
            "千秋基业，人才为本。做好新时代的组织工作，要用好人才这个第一资源。习近平在全国组织工作...\n" +
            "\n" +
            "2018-08-09 08:49:00\n" +
            "习近平谱写新时代的“长江之歌”\n" +
            "新时代的长江之歌，唱响高质量发展主旋律。\n" +
            "\n" +
            "2018-08-09 08:47:00\n" +
            "李克强会见第73届联合国大会主席埃斯皮诺萨\n" +
            "8月8日，国务院总理李克强在北戴河会见来华正式访问的第73届联合国大会主席埃斯皮诺萨。\n" +
            "\n" +
            "2018-08-09 04:42:00";



    @Test
    public static void test1(){

        String regex = "([1-9]\\d*)";

        String str = "x, 487";
        String str2 = "307 Seiten";

        Pattern p = Pattern.compile(regex);        //得到字符串中的数字
        Matcher m = p.matcher(str);
        Matcher m2 = p.matcher(str2);
        boolean b = m.find();
        if(b){
            String group = m.group();
            int i = Integer.parseInt(group);
            System.out.println(i);
        }

        boolean b1 = m2.find();
        if(b1){
            String group = m2.group();
            int i = Integer.parseInt(group);
            System.out.println(i);
        }



    }



}
