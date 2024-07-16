class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> answer = new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            if(i%15==0)
            {
                answer.add(i-1,"FizzBuzz");
            }
            else if(i%3==0)
            {
                answer.add(i-1,"Fizz");
            }
            else if(i%5==0)
            {
                answer.add(i-1,"Buzz");
            }
            else
            {
                answer.add(i-1,String.valueOf(i));
            }


        }
        return answer;

    }
}