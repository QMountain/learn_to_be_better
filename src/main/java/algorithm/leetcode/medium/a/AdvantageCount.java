package algorithm.leetcode.medium.a;

import java.util.Arrays;

public class AdvantageCount {

    int length;
    int[][] arr1;
    int[][] arr2;

    public int[] advantageCount(int[] nums1, int[] nums2) {
        this.length = nums1.length;
        int[] n1Copy = new int[length];
        System.arraycopy(nums1,0,n1Copy,0,length);
        Arrays.sort(n1Copy);
        System.out.println(Arrays.toString(n1Copy));
        this.arr1 = sort(nums1);
        this.arr2 = sort(nums2);
        int index1 = 0;
        int index2 = 0;
        int[] ans = new int[length];
        Arrays.fill(ans,-1);
        int[] used = new int[length];
        while (index1 < length && index2 < length) {
            System.out.println("arr1: "+arr1[index1][1]+"   arr2: "+arr2[index2][1]);
            if (arr1[index1][1] > arr2[index2][1]) {
                int putIndex = arr2[index2][0];
                ans[putIndex] = arr1[index1][1];
                int useIndex = arr1[index1][0];
                used[useIndex] = 1;
                System.out.println("i1i2++");
                index1++;
                index2++;
            } else {
                System.out.println("i1++");
                index1++;
            }
        }
        int i = 0;
        for (int j = 0; j < length; j++) {
            if (ans[j] == -1) {
                while (used[i] == 1) {
                    i++;
                }
                ans[j] = nums1[i++];
            }
        }
        return ans;
    }

    public int[][] sort(int[] nums) {
        int[][] arr = new int[length][2];
        for (int i = 0; i < length; i++) {
            arr[i][0] = i;
            arr[i][1] = nums[i];
        }
        Arrays.sort(arr, (a,b)->{
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        return arr;
    }

    public static void main(String[] args) {
        AdvantageCount advantageCount = new AdvantageCount();
        System.out.println(Arrays.toString(advantageCount.advantageCount(new int[]{196,70,745,239,802,553,821,175,357,890,114,506,424,938,189,652,162,452,358,182,742,438,726,877,118,928,963,453,33,259,104,171,275,557,96,942,467,254,21,587,806,857,619,545,19,394,989,177,828,642,676,477,401,778,725,517,1,438,253,81,517,390,993,294,865,150,546,356,28,97,570,868,29,193,816,644,687,538,243,495,45,857,7,40,537,83,330,758,419,677,259,960,76,619,207,409,299,3,969,693,800,0,686,660,188,75,691,413,357,919,860,200,750,20,290,4,671,191,500,304,226,754,238,628,590,915,184,116,741,361,786,299,91,912,759,979,994,185,64,237,266,785,694,224,684,373,948,844,112,552,165,870,966,735,767,178,368,995,362,813,486,861,955,847,916,362,133,764,875,421,375,649,960,124,812,794,702,798,580,828,588,873,942,50,618,978,367,22,393,586,256,905,7,296,812,248,182,306,193,735,864,229,857,855,400,398,881,276,684,949,569,250,546,572,481,208,21,835,3,685,286,305,49,567,198,144,535,379,321,249,433,744,966,512,326,185,739,199,162,590,493,56,0,4,268,830,809,295,938,430,587,748,113,184,852,260,744,451,323,947,643,80,285,234,945,638,214,412,123,7,533,406,349,834,778,856,673,927,840,412,727,205,74,1,439,267,370,702,34,683,386,38,492,751,157,711,902,222,922,250,374,679,170,425,654,310,81,765,714,219,357,210,529,857,666,774,639,399,259,92,694,340,32,357,893,637,424,56,749,562,160,656,787,201,940,564,995,249,633,523,160,128,88,889,964,39,442,597,560,591,667,212,10,711,993,901,965,285,762,667,50,455,219,730,258,553,565,578,908,105,702,482,113,933,348,619,273,118,833,97,721,973,232,62,344,104,997,106,168,40,1000,601,80,11,426,269,836,789,246,3,261,151,230,222,668,433,904,815,479,474,506,974,420,431,159,899,793,675,782,379,827,205,0,672,750,573,538,546,37,561,864,19,258,518,397,685,154,612,500,784,636,685,286,916,359,617,334,852,730,575,932,913,367,263,323,245,286,107,765,373,858,9,304,961,870,995,971,889,645,966,145,459,571,782,586,199,871,508,643,10,986,26,987,626,469,645,475,938,815,13,429,321,780,320,350,945,559,333,238,9,206,200,746,959,385,62,20,986,884,878,717,507,323,351,487,199,424,946,520,518,485,506,893,649,737,927,759,707,839,415,612,263,873,820,475,648,958,317,576,876,514,80,199,87,367,62,738,171,13,50,37,826,37,373,843,828,278,14,851,652,916,692,757,618,677,622,118,248,726,935,159,188,314,563,882,158,953,483,52,518,354,400,899,30,294,547,353,494,686,461,90,553,57,347,753,251,230,189,21,577,182,731,68,119,626,616,284,151,846,619,475,135,334,617,146,559,865,406,538,412,121,547,82,894,928,920,873,246,603,747,434,697,634,70,48,902,904,720,525,797,914,753,680,47,253,333,458,292,801,994,393,804,314,783,261,349,194,533,309,889,131,897,218,217,688,681,145,599,368,608,423,489,100,89,850,141,836,307,683,413,490,253,289,154,791,15,872,786,250,200,823,431,217,542,928,868,542,549,733,338,38,517,110,285,310,536,44,235,11,855,987,708,19,124,759,475,709,353,922,300,591,568,268,286,958,924,854,726,570,321,104,935,777,258,883,582,92,321,237,767,826,628,437,854,406,145,652,907,890,826,437,483,638,535,919,679,847,613,63,79,245,592,886,894,595,266,591,243,521,493,935,904,49,820,602,599,448,890,777,144,347,251,221,206,671,367,248,328,845,146,871,601,478,163,998,829,621,534,613,392,27,187,337,102,759,552,840,885,584,660,219,104,735,875,215,847,421,584,883,902,815,828,697,832,815,265,577,51,202,938,178,405,204,234,412,93,742,220,148,458,474,404,969,945,852,574,131,687,244,551,148,681,216,940,768,561,110,208,443,712,471,892,557,258,205,64,815,888,838,893,838,495,395,596,934,197,954,717,136,28,149,884,299,804,706,194,337,244,115,334,699,504,542,465,636,561,149,99,332,706,799,524,860,662,813,631,884,316,246,633,639,551,246,750,654,460,556,294,389,967,141,492,609,500,458,99,798,64,363,398,170,890,826,22,38,59,233,174,473,127,41,1000,888,76,344,202,144,556,435,314,494,481,42,79,417,707,810,401,16,864,29,269,589,484,264,612,168,761,34,34,323,798,853,918,409,916,381,514,197,631,263,879,322,914,555,379,652,232,490,447,248,30,134,801,18,334,206,93,508,881}, new int[]{435,950,262,806,19,175,740,43,481,484,805,632,745,67,164,578,516,915,945,823,785,268,579,507,672,279,437,237,756,24,824,836,107,841,178,655,62,281,574,952,633,183,48,808,261,455,709,694,191,510,975,330,589,422,26,938,363,987,480,537,297,58,777,260,821,633,909,341,338,669,515,939,411,810,254,289,588,562,249,59,61,358,353,432,461,334,196,231,498,949,946,911,296,321,241,863,719,946,140,23,400,78,473,595,991,449,742,747,679,550,648,846,208,34,718,150,753,423,941,658,322,147,43,81,438,717,993,739,529,580,584,58,587,67,160,889,304,667,322,203,430,575,923,575,146,1,519,93,328,82,54,778,545,413,642,850,20,925,741,619,607,838,604,851,349,183,616,736,958,853,607,819,720,600,707,139,335,580,222,280,47,5,991,55,120,663,562,127,544,637,86,757,185,106,821,443,124,685,212,533,101,692,637,330,83,672,298,859,946,72,64,39,12,11,969,294,753,633,708,324,321,204,31,549,147,628,207,198,283,108,439,809,91,670,36,243,282,353,771,25,438,384,276,156,224,567,852,906,373,54,290,715,360,410,199,867,655,448,480,57,457,882,600,676,340,451,674,485,269,152,318,372,611,163,836,212,611,657,732,807,692,134,372,84,955,301,580,866,652,928,462,843,603,335,399,702,111,655,516,416,91,650,46,173,990,44,930,496,342,149,898,190,670,482,150,136,181,65,990,241,950,260,515,174,645,294,26,145,435,73,89,364,611,237,627,672,732,987,962,332,551,934,798,760,871,499,363,439,738,429,95,874,127,942,797,472,983,154,302,92,167,435,66,710,444,405,418,304,829,170,712,124,729,359,157,788,77,784,350,207,77,877,68,846,227,600,533,674,401,453,400,607,697,319,877,981,569,666,853,736,788,29,489,893,618,733,119,98,130,245,661,701,127,929,749,890,544,569,161,395,658,980,751,183,812,920,179,931,891,778,19,871,910,105,909,827,194,215,406,640,704,496,431,303,80,429,164,117,345,511,965,510,738,73,674,435,243,778,342,193,770,908,74,741,561,834,265,736,915,216,768,388,809,282,795,214,632,578,197,5,470,923,656,917,730,372,893,673,503,633,186,546,455,905,317,389,248,900,417,932,61,841,664,982,320,331,563,291,641,806,592,168,707,907,831,682,442,82,653,324,54,61,464,130,505,477,956,205,724,463,58,63,253,127,670,382,614,120,238,637,17,383,305,889,331,893,995,248,152,199,518,133,165,388,74,117,66,407,615,354,563,525,748,87,248,749,165,787,840,702,477,525,433,113,433,269,604,391,187,42,537,246,3,565,927,667,46,820,80,381,878,251,477,526,682,447,856,4,634,414,673,160,714,724,116,776,824,746,72,240,287,801,849,26,551,982,411,764,900,732,731,1,382,191,1,724,585,811,202,307,673,564,847,413,735,46,370,493,231,931,703,995,906,220,856,721,82,100,95,673,124,317,190,79,266,158,925,937,128,199,931,336,271,815,400,784,817,69,559,337,716,504,439,851,861,827,901,207,333,913,545,57,973,407,436,689,992,560,483,229,103,81,46,67,447,611,519,618,136,913,846,883,603,424,685,853,61,54,107,87,693,0,791,609,590,405,247,49,792,10,493,86,130,826,447,318,748,99,282,531,359,473,612,154,693,272,470,801,302,968,426,651,881,887,32,198,980,307,392,686,623,709,747,576,297,741,508,296,370,394,397,733,768,138,975,54,731,940,497,508,406,403,896,995,402,979,167,785,64,907,285,51,612,827,597,426,980,472,289,262,444,787,337,567,480,681,931,444,944,197,163,533,35,497,559,173,214,337,820,868,32,446,989,663,537,536,129,315,421,84,516,20,606,815,380,729,889,371,118,275,614,840,199,971,18,876,581,996,759,888,923,805,219,461,512,147,931,299,140,261,114,168,968,295,99,142,726,107,856,422,250,86,646,632,268,173,62,183,471,18,78,738,421,971,259,633,160,587,234,266,1000,8,723,313,742,602,155,246,942,973,137,634,418,274,813,135,689,66,157,24,117,993,755,939,857,53,848,331,155,781,90,354,722,637,778,828,662,3,522,359,596,627,398,854,167,183,626,951,165,660,765,342,868,623,531,145,496,463,972,559,711,798,901,196,209,798,266,184,49,505,519,197,943,130,302,172,358,902,910,124,303,26,635,607,735,465,156,285,945,330,750,700,816,532,366,824,308,898,609,291,131,478,307,219,70,93,922,975,714,313,37,828,423,874,472,519,163,703,436,5})));
        System.out.println(Arrays.toString(advantageCount.advantageCount(new int[]{2,0,4,1,2}, new int[]{1,3,0,0,2})));
        System.out.println(Arrays.toString(advantageCount.advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11})));
        System.out.println(Arrays.toString(advantageCount.advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11})));
    }
}
