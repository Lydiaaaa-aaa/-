package com.app.login.entity;

import com.app.login.R;

import java.util.ArrayList;
import java.util.List;

public class DataService {

    public static List<Product_info> getListData(int p) {
        List<Product_info> list = new ArrayList<>();
        if (p == 0) {
            list.add(new Product_info(1, 2609,"品牌：House of CB\n" +
                    "风格：度假风\n" +
                    "款式：印花裙\n" +
                    "服装版型：大摆型\n" +
                    "袖型：无袖\n" +
                    "材质成分：莱赛尔（85%） 聚酯纤维（15%）\n" +
                    "货号：SB10291A\n" +
                    "领子：花边领\n" +
                    "尺码：XS S M L XL\n" +
                    "颜色分类：玫瑰印花","House of CB度假风休闲玫瑰印花束身中长连衣裙Kelly",R.mipmap.fuz_1));

            list.add(new Product_info(2, 2079,"风格：度假风\n" +
                    "品牌：House of CB\n" +
                    "服装版型：茶歇裙\n" +
                    "袖型:无袖\n" +
                    "材质成分\n" +
                    "棉65% 聚酰胺纤维(锦纶)32% 聚氨酯弹性纤维（氨纶）3%\n" +
                    "款式：大摆型\n" +
                    "货号：SB8414H\n" +
                    "尺码\n" +
                    "XS S M L XL\n" +
                    "颜色分类\n" +
                    "法式海军蓝","House of CB 超好看吊带连衣裙气质中长裙2024新款束腰裙子Carmen",R.mipmap.fuz_2));

            list.add(new Product_info(1002, 2729,"风格：度假风\n" +
                    "品牌：House of CB\n" +
                    "服装版型：茶歇裙\n" +
                    "袖型:无袖\n" +
                    "材质成分\n" +
                    "棉65% 聚酰胺纤维(锦纶)32% 聚氨酯弹性纤维（氨纶）3%\n" +
                    "款式：大摆型\n" +
                    "货号：SB8414H\n" +
                    "尺码\n" +
                    "XS S M L XL\n" +
                    "颜色分类\n" +
                    "灰姑娘蓝色\n","House of CB 休闲度假风薄纱中长连衣裙Mademoiselle",R.mipmap.fuz_3));

            list.add(new Product_info(1003,2729,"风格：度假风\n" +
                    "品牌：House of CB\n" +
                    "服装版型：茶歇裙\n" +
                    "袖型:无袖\n" +
                    "材质成分\n" +
                    "棉65% 聚酰胺纤维(锦纶)32% 聚氨酯弹性纤维（氨纶）3%\n" +
                    "款式：大摆型\n" +
                    "货号：SB8414H\n" +
                    "尺码\n" +
                    "XS S M L XL\n" +
                    "颜色分类\n" +
                    "意式玫瑰印花\n","House of CB 田园风意式玫瑰印花薄纱中长连衣裙Mademoiselle",R.mipmap.fuz_4));

            list.add(new Product_info(1020,2469,"风格：度假风\n" +
                    "品牌：House of CB\n" +
                    "服装版型：茶歇裙\n" +
                    "袖型:无袖\n" +
                    "材质成分\n" +
                    "棉65% 聚酰胺纤维(锦纶)32% 聚氨酯弹性纤维（氨纶）3%\n" +
                    "款式：大摆型\n" +
                    "货号：SB8414H\n" +
                    "尺码\n" +
                    "XS S M L XL\n" +
                    "颜色分类\n" +
                    "粉色牡丹\n","House of CB超好看休闲粉色印花连衣裙2024新款吊带长裙女Rosalee",R.mipmap.fuz_5));
            list.add(new Product_info(6,2469,"度假风\n" +
                    "品牌：House of CB\n" +
                    "服装版型：茶歇裙\n" +
                    "袖型:无袖\n" +
                    "材质成分\n" +
                    "棉65% 聚酰胺纤维(锦纶)32% 聚氨酯弹性纤维（氨纶）3%\n" +
                    "款式：大摆型\n" +
                    "货号：SB8414H\n" +
                    "尺码\n" +
                    "XS S M L XL\n" +
                    "颜色分类\n" +
                    "白色\n","House of CB优雅纯色白色束腰中长连衣裙Samaria",R.mipmap.fuz_6));
            list.add(new Product_info(1022,2469,"风格：度假风\n" +
                    "品牌：House of CB\n" +
                    "服装版型：茶歇裙\n" +
                    "袖型:无袖\n" +
                    "材质成分\n" +
                    "棉65% 聚酰胺纤维(锦纶)32% 聚氨酯弹性纤维（氨纶）3%\n" +
                    "款式：大摆型\n" +
                    "货号：SB8414H\n" +
                    "尺码\n" +
                    "XS S M L XL\n" +
                    "颜色分类\n" +
                    "蓝色花卉印花","House of CB俏皮甜美蓝色花卉印花棉质迷你连衣裙Calia",R.mipmap.fuz_7));
            list.add(new Product_info(8,2469,"风格：度假风\n" +
                    "品牌：House of CB\n" +
                    "服装版型：茶歇裙\n" +
                    "袖型:无袖\n" +
                    "材质成分\n" +
                    "棉65% 聚酰胺纤维(锦纶)32% 聚氨酯弹性纤维（氨纶）3%\n" +
                    "款式：大摆型\n" +
                    "货号：SB8414H\n" +
                    "尺码\n" +
                    "XS S M L XL\n" +
                    "颜色分类\n" +
                    "奶油色花卉印花","House of CB优雅百搭奶油色花卉印花束腰中长连衣裙Rosalee",R.mipmap.fuz_8));
            list.add(new Product_info(9,2469,"风格：度假风\n" +
                    "品牌：House of CB\n" +
                    "服装版型：茶歇裙\n" +
                    "袖型:无袖\n" +
                    "材质成分\n" +
                    "棉65% 聚酰胺纤维(锦纶)32% 聚氨酯弹性纤维（氨纶）3%\n" +
                    "款式：大摆型\n" +
                    "货号：SB8414H\n" +
                    "尺码\n" +
                    "XS S M L XL\n" +
                    "颜色分类\n" +
                    "柠檬色印花","House of CB休闲风优雅柠檬色印花棉质中长连衣裙 Rosalee",R.mipmap.fuz_9));
            list.add(new Product_info(10,2469,"度假风\n" +
                    "品牌：House of CB\n" +
                    "服装版型：茶歇裙\n" +
                    "袖型:无袖\n" +
                    "材质成分\n" +
                    "棉65% 聚酰胺纤维(锦纶)32% 聚氨酯弹性纤维（氨纶）3%\n" +
                    "款式：大摆型\n" +
                    "货号：SB8414H\n" +
                    "尺码\n" +
                    "XS S M L XL\n" +
                    "颜色分类\n" +
                    "丁香紫花卉印花","House of CB休闲风丁香紫花卉印花棉质中长连衣裙Kim",R.mipmap.fuz_10));

        } else if (p == 1) {
            list.add(new Product_info(11,52,"品牌：良品铺子\n" +
                    "净含量：235g\n" +
                    "包装种类：袋装\n" +
                    "生产日期：25年2月起\n" +
                    "产地：中国大陆\n" +
                    "食品添加剂\n" +
                    "见包装\n","良品铺子迷你小香肠肉肠拇指肠火腿肠猪肉脯熟食休闲解馋小零食",R.mipmap.ship_1));
            list.add(new Product_info(12,33,"品牌：良品铺子\n" +
                    "净含量：235g\n" +
                    "包装种类：袋装\n" +
                    "生产日期：25年2月起\n" +
                    "产地：中国大陆\n" +
                    "食品添加剂：见包装\n" +
                    "保质期\n" +
                    "240天\n","良品铺子安格斯牛排脆肉类即食小吃解馋特产牛肉干脆片零食",R.mipmap.ship_2));
            list.add(new Product_info(13,9,"品牌：良品铺子\n" +
                    "净含量：235g\n" +
                    "包装种类：袋装\n" +
                    "生产日期：25年2月起\n" +
                    "产地：中国大陆\n" +
                    "食品添加剂：见包装\n" +
                    "保质期\n" +
                    "180天","良品铺子零食大礼包35包11种辣卤小鱼肉脯辣条追剧解馋小零食批发",R.mipmap.ship_3));

        } else if (p == 2) {
            list.add(new Product_info(15,61,"品牌\n" +
                    "德意邦（清洁工具）\n" +
                    "材质\n" +
                    "塑料\n" +
                    "风格\n" +
                    "北欧风格\n" +
                    "安装方式\n" +
                    "免打孔\n" +
                    "颜色分类\n" +
                    "各类马桶上方适用 浴室化妆品也可整齐收纳 1个装优雅灰? 1个装绅士黑? 2个装优雅灰?直降6元 2个装绅士黑?直降6元 2个装灰+黑?直降6元 3个装优雅灰?直降12元 3个装绅士黑?直降12元\n" +
                    "货号\n" +
                    "SQ-5305a\n" +
                    "层数\n" +
                    "3层\n" +
                    "是否手工\n" +
                    "否","川岛屋可爱碗碟套装一人食餐具搬家乔迁新居礼品女生闺蜜生日礼物",R.mipmap.jiaj_1));
            list.add(new Product_info(16,19,"品牌\n" +
                    "surepower/速豹\n" +
                    "货号\n" +
                    "【B】LF01无火香薰 【B0208008】+A3\n" +
                    "是否可定制\n" +
                    "否\n" +
                    "适用节日\n" +
                    "节日通用\n" +
                    "礼品类别\n" +
                    "创意类礼品\n" +
                    "适用对象\n" +
                    "其他\n" +
                    "适用场景\n" +
                    "日常\n" +
                    "包装种类\n" +
                    "简装\n" +
                    "颜色分类\n" +
                    "许愿精灵*2瓶+薰衣草*2瓶【50ml*4瓶】 白茶*2瓶+香格里拉*2瓶【50ml*","全友家居奶油风布艺沙发客厅2025新款现代简约可拆洗直排云浪沙发",R.mipmap.jiaj_2));
            list.add(new Product_info(17,125,"品牌\n" +
                    "故宫\n" +
                    "风格\n" +
                    "中国风\n" +
                    "是否可定制\n" +
                    "否\n" +
                    "适用节日\n" +
                    "节日通用\n" +
                    "礼品类别\n" +
                    "实用类礼品\n" +
                    "适用对象\n" +
                    "朋友\n" +
                    "适用场景\n" +
                    "祝福\n" +
                    "包装种类\n" +
                    "盒装\n" +
                    "颜色分类\n" +
                    "千里江山·温感杯.","全友家居2025新款现代简约可拆洗猫抓布沙发客厅小户型直排沙发",R.mipmap.jiaj_3));

        } else if (p==3){
            list.add(new Product_info(19,713,"品牌\n" +
                    "富士\n" +
                    "型号\n" +
                    "instax mini 12\n" +
                    "对焦方式\n" +
                    "固定对焦\n" +
                    "保修期\n" +
                    "12个月\n" +
                    "是否有近拍镜\n" +
                    "有\n" +
                    "生产企业\n" +
                    "富士株式会社\n" +
                    "颜色分类\n" +
                    "绣球蓝 鸢尾紫 薄荷绿\n","【自营】富士mini 12 立拍立得可爱相机毕业男女学生日礼物海外版",R.mipmap.dianz_1));
            list.add(new Product_info(20,1336,"品牌\n" +
                    "富士\n" +
                    "型号\n" +
                    "instax mini 99\n" +
                    "对焦方式\n" +
                    "固定对焦\n" +
                    "保修期\n" +
                    "12个月\n" +
                    "是否有近拍镜\n" +
                    "有\n" +
                    "生产企业\n" +
                    "富士株式会社\n" +
                    "颜色分类\n" +
                    "黑色","富士 instax mini 99拍立得mini90富士迷你99 90 40 一次成像相机",R.mipmap.dianz_2));
            list.add(new Product_info(21,5499,"品牌\n" +
                    "富士\n" +
                    "型号\n" +
                    "instax wide 400\n" +
                    "对焦方式\n" +
                    "固定对焦\n" +
                    "保修期\n" +
                    "12个月\n" +
                    "是否有近拍镜\n" +
                    "有\n" +
                    "生产企业\n" +
                    "富士株式会社\n" +
                    "颜色分类\n" +
                    "原野绿","富士instax wide400相机含拍立得相纸 旷野图腾 宽幅wide300升级",R.mipmap.dianz_3));

        } else {
            list.add(new Product_info(23,195,"书名\n" +
                    "2026王道408全套4本\n" +
                    "ISBN编号\n" +
                    "9787557214166\n" +
                    "出版社名称\n" +
                    "山东省地图出版社\n" +
                    "定价\n" +
                    "195元\n" +
                    "是否是套装\n" +
                    "是\n" +
                    "作者\n" +
                    "王道" ,"2026版王道考研数据结构计算机专业基础综合考试模拟题",R.mipmap.tus_1));
            list.add(new Product_info(24,40,"ISBN编号\n" +
                    "9787040492453\n" +
                    "书名\n" +
                    "选择题专项突破1800题\n" +
                    "作者\n" +
                    "无\n" +
                    "定价\n" +
                    "40元\n" +
                    "是否是套装\n" +
                    "否\n" +
                    "出版社名称\n" +
                    "高等教育出版社","【图领计算机】2026年 408计算机考研选择题专项突破1800题 书课包 专业课 复习辅导书",R.mipmap.tus_2));
            list.add(new Product_info(25,56,"书名\n" +
                    "408学霸笔记\n" +
                    "ISBN编号\n" +
                    "9787040604931\n" +
                    "科目\n" +
                    "408\n" +
                    "是否是套装\n" +
                    "否\n" +
                    "作者\n" +
                    "一大颗牛奶糖","一大颗牛奶糖408笔记计算机考研学霸高分参考书教材数据结构组成原理操作系统网络王道考研复习指导专业基础综合考试",R.mipmap.tus_3));
            list.add(new Product_info(26,65,"书名\n" +
                    "竞成408考研\n" +
                    "ISBN编号\n" +
                    "9787040604931\n" +
                    "科目\n" +
                    "408\n" +
                    "是否是套装\n" +
                    "是\n" ,"【官方现货】26版竟成408计算机考研复习全书高分笔记数据结构/组成原理/操作系统/计算机网络408真题模拟教材竞成王道天勤辅导书",R.mipmap.tus_4));


        }
        return list;
    }
}
