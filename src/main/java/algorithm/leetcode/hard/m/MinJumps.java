package algorithm.leetcode.hard.m;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName MinJumps
 * @Description
 * @Author qsf
 * Date   2022-01-24  22:07
 */
public class MinJumps {

    /**
     * 跳跃游戏 IV  hard
     * @param arr
     * @return
     */
    public int minJumpsHardUseDP(int[] arr) {
        int length = arr.length;
        if (length == 1) {
            return 0;
        }
        if (arr[0] == arr[length-1]) {
            return 1;
        }
        Map<Integer,Integer> map = new HashMap<>(length);
        map.put(arr[1],1);
        map.put(arr[0],0);
        int[] dp = new int[length];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < length; i++) {
            int num = arr[i];
            int m1 = length;
            if (map.containsKey(num)) {
                m1 = map.get(num)+1;
            }
            int m2 = dp[i-1]+1;
            int min = Math.min(m1,m2);
            dp[i] = min;
            map.put(num,Math.min(map.getOrDefault(num, length),min));
            if (dp[i] + 1 < dp[i-1]) {
                int goBackStep = (dp[i-1] - dp[i]) / 2;
                for (int j = i-1; j > i-1-goBackStep; j--) {
                    dp[j] = Math.min(dp[j],dp[j+1]+1);
                    map.put(arr[j],Math.min(map.get(arr[j]),dp[j]));
                }
            }
        }
        return dp[length-1];
    }

    /**
     * 跳跃游戏 IV  hard
     * @param arr
     * @return
     */
    public int minJumpsHard(int[] arr) {
        int length = arr.length;
        if (length == 1) {
            return 0;
        }
        if (arr[0] == arr[length-1]) {
            return 1;
        }
        Map<Integer,Set<Integer>> points = new HashMap<>(length);
        for (int i = 1; i < length; i++) {
            int num = arr[i];
            HashSet<Integer> set = new HashSet<>(
                    points.getOrDefault(num, new HashSet<>(length)));
            set.add(i);
            points.put(num,set);
        }
        int jumpTimes = 1;
        Set<Integer> canArrivePositions = new HashSet<>(
                points.getOrDefault(arr[0],new HashSet<>()));
        canArrivePositions.add(1);
        Set<Integer> passed = new HashSet<>(canArrivePositions);
        passed.add(0);
        while (!canArrivePositions.contains(length-1)) {
            jumpTimes++;
            Set<Integer> newPositions = new HashSet<>();
            for (Integer position : canArrivePositions) {
                newPositions.addAll(points.get(arr[position]));
                newPositions.add(position-1);
                newPositions.add(position+1);
            }
            newPositions.removeAll(passed);
            passed.addAll(newPositions);
            canArrivePositions = newPositions;
        }
        return jumpTimes;
    }

    public int minJumps(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        Set<Integer> calculatedPoint = new HashSet<>(arr.length/2);
        Set<Integer> startPointIndexSet = getPointCanArriveIndexSet(0,arr);
        if (startPointIndexSet.contains(arr.length-1)) {
            return 1;
        }
        int jumpTimes = 1;
        boolean canArriveEnd = false;
        while (!canArriveEnd) {
            startPointIndexSet = getNextJumpCanArriveSet(arr, startPointIndexSet,calculatedPoint);
            jumpTimes++;
            if (startPointIndexSet.contains(arr.length-1)) {
                canArriveEnd = true;
            }
        }
        return jumpTimes;
    }

    private Set<Integer> getPointCanArriveIndexSet(Integer pointIndex, int[] arr) {
        Set<Integer> res = new HashSet<>();
        // find equals
        for (int j = 1; j < arr.length; j++) {
            if (pointIndex != j && arr[pointIndex] == arr[j]) {
                res.add(j);
            }
        }
        // add right
        if (pointIndex < arr.length-1) {
            res.add(pointIndex+1);
        }
        // add left
        if (pointIndex > 1) {
            res.add(pointIndex-1);
        }
        return res;
    }

    private Set<Integer> getNextJumpCanArriveSet(int[] arr, Set<Integer> startPointIndexSet,
                                                 Set<Integer> calculatedPoint) {
        Set<Integer> res = new HashSet<>();
        for (Integer startPointIndex : startPointIndexSet) {
            Set<Integer> canArriveSet = new HashSet<>();
            if (!calculatedPoint.contains(startPointIndex)) {
                canArriveSet = getPointCanArriveIndexSet(startPointIndex,arr);
                calculatedPoint.add(startPointIndex);
            }
            res.addAll(canArriveSet);
        }
        return res;
    }

    public static void main(String[] args) {
        MinJumps minJumps = new MinJumps();
        System.out.println(3 == minJumps.minJumpsHardUseDP(new int[]{7,7,2,1,7,7,7,3,4,1}));
        System.out.println(2 == minJumps.minJumpsHardUseDP(new int[]{7,7,7,7,7,7,7,7,7,7,11}));
        System.out.println(2 == minJumps.minJumpsHardUseDP(new int[]{6,1,9}));



        System.out.println(3 == minJumps.minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404}));
        System.out.println(1 == minJumps.minJumps(new int[]{7,6,9,6,9,6,9,7}));
        System.out.println(2 == minJumps.minJumps(new int[]{6,1,9}));
        System.out.println(3 == minJumps.minJumps(new int[]{11,22,7,7,7,7,7,7,7,22,13}));

        long start = System.currentTimeMillis();
        System.out.println(minJumps.minJumps(new int[]{-3438,8687,-4721,3059,-4473,1756,3361,1416,5415,-2794,4722,-849,-4360,8236,-4053,-5199,-4873,4192,4757,-4220,1458,3802,-887,855,-1183,5945,-7241,-2952,1748,-3920,973,1811,-4267,311,-3216,2898,7054,-3236,8613,9272,392,4299,-4317,-2258,-2124,-106,1688,-1247,-8715,-6446,-8068,2294,692,-394,6344,-1077,-5143,-2138,-886,2582,-8434,8367,-4563,-1241,1280,-4878,410,-3861,-9765,7206,9097,2188,-1267,-5605,-3496,-2328,-8123,56,-2240,-378,-2245,-2963,5611,1075,3594,-4426,-129,4662,-4717,747,5122,-9425,8809,-8425,2446,-972,5449,4643,-2658,8949,-7998,9165,3010,3976,4154,-4180,-7712,2670,-4695,2208,-6627,4949,-8482,7640,377,5389,178,2763,-2829,-7981,-796,-4939,-9944,5219,-4000,-3424,5962,8725,-2740,1169,-6628,-6706,6496,9577,2997,3666,-5796,-2815,3495,3930,410,-5778,2150,-2142,4431,-8907,1720,7343,-6055,-324,785,-1216,-9873,-8674,1767,-8650,5931,-2141,-278,5258,4187,228,1584,3195,-4917,8584,2086,1909,3080,-8150,-6014,8702,-9234,5325,-2330,4180,6518,-6859,5960,-8853,7133,-4263,3232,9098,1615,-7526,-7801,2464,5456,-441,2700,-7393,6435,4658,5809,-6021,4680,9843,-2753,-7031,-6070,-7183,-6122,4613,462,7701,-6857,-3411,890,-1343,-2436,3298,-748,5761,-424,7795,-6750,1702,7226,50,-4550,-4375,2363,-8338,6343,3929,4978,7795,-5247,7825,3769,7579,-8305,-9036,-4088,6371,-6606,-5229,-9732,7958,5167,2615,7514,-3697,4105,-9758,-7021,8834,-9999,3855,6101,890,-3948,5313,653,-5692,-1232,2178,7772,-5541,849,4237,-3949,-6502,-9496,-3273,-9157,-7177,982,136,7151,-462,3575,4639,9125,-2470,687,9671,5429,-5734,-157,1349,9739,-1789,-5528,-5590,-4837,5187,-7218,3351,-8064,5960,-2212,-9753,-4,8836,783,-5505,-4564,1586,3510,-2931,6245,-3971,-6685,-2346,9788,4587,-3233,-6307,9259,6974,-2825,9486,-1119,-9492,8720,8689,964,2435,-3598,-6139,7683,-4683,-4726,-440,-3732,-9390,-4396,6019,-3796,-2804,-7316,-2275,-2453,-6180,7207,-3366,2366,-8471,-7286,-4573,-348,1360,5582,-3873,-66,6086,7122,5272,3148,-1037,-8550,-4894,523,5534,-1096,9047,3914,-1571,-8340,3364,6756,-7791,-1516,9441,-5270,7702,-5703,-4386,6268,2245,2033,1993,3976,-4289,9807,-9219,1605,2042,2661,2545,7593,-7786,7546,2878,6794,-2408,2411,4694,4475,4304,-2327,6601,-5974,7485,-9363,-6013,-2916,4224,7020,-3399,-9696,2009,-2793,704,-3545,-2464,-4029,-4357,-4600,1718,3592,-9192,-6888,-5854,6432,-4003,-9896,-1577,-3160,-6014,3880,311,-370,3811,7788,-8533,5941,-3598,-9435,8310,-9182,-6161,6493,4868,-5095,7676,2113,196,-6894,655,7019,-5242,-2176,5719,6983,-8379,-2699,-3262,6728,3055,1159,-5633,-8827,3557,-579,-27,-5559,7919,-4410,5872,8019,-7069,-6062,-622,-5302,-1586,-3644,-3206,-6677,7230,8897,2789,540,-1646,1477,7885,-8066,-7766,4745,-972,-7293,3445,4249,-1349,-2873,-9823,-3867,9806,-4508,5737,-5789,2690,-8671,9130,-2092,-5612,-3858,-1530,2227,3484,-841,5606,8839,7144,6426,6238,-8276,-6221,-8112,2805,-3932,-814,-8252,1277,-6977,1659,-7065,-9743,-6025,3914,6432,6712,-1276,-6901,-2036,6377,6969,-9667,-7368,1231,-7754,2433,-3050,9697,9812,-4439,3184,7329,-8856,-3376,-1999,5585,4983,-4555,4125,-7229,-9159,8314,2581,7383,-7538,-921,949,7817,5943,-9240,-5504,4289,-7815,2965,-6192,-884,6604,-4815,-8730,4094,-8333,-7847,-7769,-5218,-9948,3249,660,217,-7544,-9979,-1119,8374,-1108,-3011,3807,1662,-2484,-7795,-3367,7510,1070,-9368,-9652,6057,9511,2252,5150,785,-775,7655,8903,-8083,6035,-3166,249,5433,6836,8489,-9139,7160,1548,2900,-6285,4972,-8476,5540,-9455,-4307,-700,5323,-6398,-1348,7163,3510,6911,6880,5119,-1262,4513,4962,11,3230,-5370,-6220,-254,-5993,-9143,-877,-7505,9577,-2976,-5598,5314,-569,-3552,237,5740,-8796,-5466,-3732,8157,-3547,8631,-9931,-3271,-8708,1137,-6345,3310,9755,-9955,-3683,-7859,-2616,-9700,-8775,3306,-2186,-2248,-6684,4118,384,7096,7611,-7965,1204,9856,-5741,7051,-5209,5100,1389,-597,2569,-4993,5770,9451,6002,6760,-630,-6252,2569,-9924,5994,-2897,6344,4066,7872,-4747,-7200,-3909,7066,-9852,-6140,-3315,9152,-422,-2699,6920,6247,7143,-777,3787,5523,-3203,-6547,-9071,-4107,-254,-5292,7840,-7443,-7186,-9151,-3283,438,2271,-4201,1749,7528,-222,-7938,-720,-6499,9898,-7573,3978,7712,7397,-8556,421,-669,9967,-8571,-4285,-3323,5301,-5094,7802,775,2538,-7133,-2142,-6977,-2190,-725,-8739,-1718,-3247,7509,-8321,-1332,9399,-47,3200,9168,6601,401,-7402,-6324,4489,8584,6803,9757,6740,6640,9149,4326,5639,5125,-8898,-5486,4315,-1240,-63,5727,-376,-3484,-681,-4829,7633,-2581,6747,-9332,-6937,-8559,8054,2111,704,-6410,-6165,5531,3323,-4507,-5282,-7514,9785,7154,3010,-3992,-3310,4173,-7768,2940,5682,5479,-4018,7457,1781,-9140,-8787,2346,8953,-9697,4941,-912,6870,-4771,-2562,-4837,-2759,-8203,646,9421,-12,-7681,7033,-6291,3134,5673,-2843,-4654,-394,7032,4155,-1161,1091,8650,-1561,-2848,3798,-30,6183,-8384,3128,-2134,-6723,1280,3384,8465,1573,7947,-7586,-4506,-4184,-1709,-9210,6913,3457,9001}));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
