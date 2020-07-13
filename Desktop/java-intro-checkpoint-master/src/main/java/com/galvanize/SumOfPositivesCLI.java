package com.galvanize;

public class SumOfPositivesCLI
{

    public static void main(String[] args)
    {
        int [] stringToIntegers = new int[args.length];
        int sum = 0;

        for(int i = 0; i < args.length; i++)
        {
            stringToIntegers[i] = Integer.parseInt(args[i]);
        }
      for(int i = 0; i < stringToIntegers.length; i++)
      {
          if(stringToIntegers[i] > 0)
          {
              sum += stringToIntegers[i];
          }
          //System.out.println(stringToIntegers[i]);
      }
        System.out.println(sum);

    }

}
