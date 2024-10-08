package algorithm.leetcode.hard.m;

import java.util.*;

public class MinRefuelStops {

    // 0 <= stations.length <= 500
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // 初始油量就够用，直接返回结果
        if (target <= startFuel) {
            return 0;
        }
        int length = stations.length;
        // index 是加油次数
        long[] leftMaxFuelArr = new long[length+1];
        leftMaxFuelArr[0] = startFuel;
        // 当前位置
        int currPosition = 0;
        int minTimes = 0;
        for (int i = 0; i < length; i++) {
            int[] station = stations[i];
            // 下一个加油站位置
            int nextPosition = station[0];
            // 如果之前全加了也不能到达当前加油站，直接返回-1
            if (leftMaxFuelArr[i] < nextPosition - currPosition) {
                return -1;
            }
            leftMaxFuelArr[i+1] = leftMaxFuelArr[i] - (nextPosition - currPosition) + station[1];
            for (int j = i; j > minTimes; j--) {
                // 不加
                long m1 = leftMaxFuelArr[j] - (nextPosition - currPosition);
                if (m1 < 0) {
                    leftMaxFuelArr[j] = -1;
                    break;
                }
                long left = leftMaxFuelArr[j - 1] - (nextPosition - currPosition);
                if (left < 0) {
                    leftMaxFuelArr[j] = m1;
                    leftMaxFuelArr[j - 1] = -1;
                    minTimes = j-1;
                    break;
                }
                long m2 = left + station[1];
                leftMaxFuelArr[j] = Math.max(m1, m2);
            }
            leftMaxFuelArr[0] -= nextPosition - currPosition;
            currPosition = nextPosition;
        }
        for (int i = minTimes; i <= length; i++) {
            if (leftMaxFuelArr[i] >= target - currPosition) {
                return i;
            }
        }
        return -1;
    }

    public int minRefuelStops2(int target, int startFuel, int[][] stations) {
        int length = stations.length;
        if (length == 0) {
            return startFuel >= target ? 0 : -1;
        }
        if (startFuel >= target) {
            return 0;
        }
        int[] minLeftFuel = new int[length];
        minLeftFuel[length-1] = stations[length-1][1] >= target - stations[length-1][0] ?
                0 : target - stations[length-1][0] - stations[length-1][1];
        for (int i = length-2; i >= 0; i--) {
            minLeftFuel[i] = stations[i][1] >= stations[i+1][0] - stations[length-1][0] ?
                    0 : stations[i+1][0] - stations[length-1][0] - stations[i][1];
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,startFuel);
        int currentPosition = 0;
        int minAddTimes = -1;
        for (int i = 0; i < length; i++) {
            int[] station = stations[i];
            int nextStepNeedFuel = station[0] - currentPosition;
            currentPosition = station[0];
            Map<Integer,Integer> nm = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int addTimes = entry.getKey();
                int leftFuel = entry.getValue();
                if (leftFuel >= nextStepNeedFuel) {
                    if (leftFuel-nextStepNeedFuel >= minLeftFuel[i]) {
                        if (leftFuel-nextStepNeedFuel < target-station[0]) {
                            if (minAddTimes == -1 || addTimes < minAddTimes) {
                                if (nm.containsKey(addTimes)) {
                                    int oldValue = nm.get(addTimes);
                                    nm.put(addTimes,Math.max(oldValue,leftFuel-nextStepNeedFuel));
                                } else {
                                    nm.put(addTimes,leftFuel-nextStepNeedFuel);
                                }
                            }
                        } else {
                            if (minAddTimes == -1) {
                                minAddTimes = addTimes;
                            } else {
                                minAddTimes = Math.min(minAddTimes,addTimes);
                            }
                        }
                    }
                    if (leftFuel-nextStepNeedFuel+station[1] >= minLeftFuel[i]) {
                        if (leftFuel-nextStepNeedFuel+station[1] < target - station[0]) {
                            if (minAddTimes == -1 || addTimes+1 < minAddTimes) {
                                if (nm.containsKey(addTimes+1)) {
                                    int oldValue = nm.get(addTimes+1);
                                    nm.put(addTimes+1,Math.max(oldValue,leftFuel-nextStepNeedFuel+station[1]));
                                } else {
                                    nm.put(addTimes+1,leftFuel-nextStepNeedFuel+station[1]);
                                }
                            }
                        } else {
                            if (minAddTimes == -1) {
                                minAddTimes = addTimes+1;
                            } else {
                                minAddTimes = Math.min(minAddTimes,addTimes+1);
                            }
                        }
                    }
                }
            }
            if (nm.isEmpty()) {
                return minAddTimes;
            }
            map = nm;
        }
        int leftTarget = target - stations[length-1][0];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value >= leftTarget) {
                if (minAddTimes == -1) {
                    minAddTimes = key;
                } else {
                    minAddTimes = Math.min(minAddTimes,key);
                }
            }
        }
        return minAddTimes;
    }

    public static void main(String[] args) {
        MinRefuelStops minRefuelStops = new MinRefuelStops();
        System.out.println(1 == minRefuelStops.minRefuelStops(1000000000, 905020228,
                new int[][]{{151262030,251558705},{314274596,493894928},{488425232,83502071},{497662083,150054169},{511685071,384937300},{561251876,210964978},{678990826,281637332},{698362701,443188544},{850324303,106796722},{936328052,32852657}}));
        System.out.println(5 == minRefuelStops.minRefuelStops(1000, 299, new int[][]{{14,123},{145,203},{344,26},{357,68},{390,35},{478,135},{685,108},{823,186},{934,217},{959,80}}));
        System.out.println(2 == minRefuelStops.minRefuelStops(100, 10, new int[][]{{10,60},{20,30},{30,30},{60,40}}));

        System.out.println(1 == minRefuelStops.minRefuelStops(100, 50, new int[][]{{25,25},{50,50}}));
        System.out.println(-1 == minRefuelStops.minRefuelStops(100, 50, new int[][]{{25,30}}));

        //System.out.println(5 == minRefuelStops.minRefuelStops(1000000, 53667, new int[][]{{6950,13028},{21145,25000},{38690,6304},{54352,42300},{56808,45976},{63983,37886},{68419,15751},{69504,8075},{85043,32434},{92914,50646},{109806,43101},{112920,7430},{116008,35223},{121846,46938},{128528,48626},{128560,49460},{135306,1996},{151134,26992},{157586,52788},{166585,44818},{167892,13581},{202994,11028},{217878,18871},{241339,51351},{248208,38733},{257762,32253},{277792,36820},{288531,19642},{331194,18080},{348898,35356},{349346,4671},{359199,17610},{360009,5527},{368757,14195},{396664,14932},{401524,49201},{402539,35084},{422674,5352},{427795,14717},{431106,42724},{431917,46730},{437958,45353},{458031,9710},{467378,39191},{488467,49031},{495827,34298},{501568,35856},{504829,5089},{511736,30952},{516011,8269},{516355,51173},{519876,32562},{528434,18530},{561784,13822},{565838,38935},{574928,24104},{582225,5169},{593508,27144},{603060,31587},{613347,46986},{621815,47051},{641640,3362},{654360,37738},{676653,41273},{686787,13056},{695695,21872},{700010,25196},{721310,32491},{724872,26252},{725214,42539},{750190,15189},{765068,3418},{766642,23799},{769842,20742},{770378,44127},{777325,16075},{783687,15299},{783886,44121},{820968,6557},{822189,1196},{822795,49842},{824231,52596},{848150,39409},{854444,25292},{878221,22784},{889948,21445},{893844,17898},{895155,33036},{904112,40321},{911401,49930},{913887,9344},{929823,38731},{939245,45498},{952152,45798},{958422,53539},{979783,10569},{985338,5294},{991430,21666},{991970,35896},{996672,36853}}));
        System.out.println(0 == minRefuelStops.minRefuelStops(1, 1, new int[][]{}));
        System.out.println(-1 == minRefuelStops.minRefuelStops(100, 1, new int[][]{{10, 100}}));

        System.out.println(20 == minRefuelStops.minRefuelStops(1000000, 53667, new int[][]{{455,48129},{8806,36172},{38649,51620},{50425,45151},{64238,19252},{79540,27488},{92973,48487},{101482,20385},{105692,11986},{131201,22315},{135754,15636},{145916,42233},{165716,47290},{172469,36945},{177432,45297},{186727,27734},{189085,35977},{197473,36383},{209426,39520},{222862,50387},{225733,40401},{255727,10906},{273405,9385},{277169,39761},{283226,2636},{288133,8476},{308189,16439},{314498,42879},{317086,34495},{328635,46649},{338831,31480},{345799,26363},{353490,1188},{357962,52339},{361220,52146},{361275,21648},{366874,20716},{370959,28565},{377996,44626},{379326,27482},{383016,23901},{406236,40394},{421986,27643},{426439,33605},{440245,31630},{460601,29416},{472167,10490},{485392,21962},{490847,3013},{501354,12882},{502776,41392},{560535,13718},{564385,13404},{585066,47736},{590014,40717},{590300,8865},{603539,32423},{612944,10595},{616209,1101},{621211,30846},{624175,46737},{624523,1959},{633836,21549},{635771,7887},{656855,22738},{656939,8464},{667321,29290},{667879,47116},{677204,5079},{685178,5955},{699000,23265},{701966,12043},{711946,34936},{728554,11657},{741580,39222},{743479,30967},{758502,17947},{758834,30397},{762879,41023},{766606,32003},{776735,23796},{800541,33933},{811940,36565},{843625,53588},{855233,40415},{857900,3181},{872559,5206},{877039,19122},{880466,53186},{881880,51715},{917364,29500},{925336,34531},{928493,25852},{933094,45869},{938599,47431},{944052,21149},{945947,39257},{964625,2576},{986112,21349},{992853,53217}}));
        System.out.println(5 == minRefuelStops.minRefuelStops(1000000000, 145267354, new int[][]{{32131797,142290934},{86397166,44642653},{99237057,56978680},{130019011,99649968},{154227249,90514223},{198652959,102942413},{272491487,108474929},{282220105,83721209},{302284128,43151624},{318501736,107636032},{359336452,73807027},{425903682,43078334},{447483572,53751173},{469840976,57311636},{472584505,57629539},{531147470,106487691},{611722638,111485731},{650472592,20105771},{692670691,141572192},{747847056,7972504},{800899205,106134661},{825649709,136473550},{880534339,72135820},{887048383,73776979},{967172408,58930710}}));
        System.out.println(5 == minRefuelStops.minRefuelStops(1000000, 70768, new int[][]{{53850,170579},{144779,184975},{285970,250699},{551380,63687},{563517,183875},{652555,16550},{720886,328338},{821172,7541},{941712,180342},{978151,58191}}));
        System.out.println(-1 == minRefuelStops.minRefuelStops(1000000, 8663, new int[][]{{31,195796},{42904,164171},{122849,139112},{172890,121724},{182747,90912},{194124,112994},{210182,101272},{257242,73097},{284733,108631},{369026,25791},{464270,14596},{470557,59420},{491647,192483},{516972,123213},{577532,184184},{596589,143624},{661564,154130},{705234,100816},{721453,122405},{727874,6021},{728786,19444},{742866,2995},{807420,87414},{922999,7675},{996060,32691}}));


    }
}
