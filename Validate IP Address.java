class Solution {
    public String validIPAddress(String IP) {
        if(IP == null || IP.length() == 0) return "Neither";
        else if(validIPv4(IP)) return "IPv4";
        else if(validIPv6(IP)) return "IPv6";
        else return "Neither";
    }
    private boolean validIPv4(String IP){
        if(IP.charAt(IP.length() - 1) == '.') return false;
        if(IP.charAt(0) == '.') return false;
        String[] IPs = IP.split("\\.");
        if(IPs.length != 4) return false;
        for(int i = 0; i < 4; i++){
            String s = IPs[i];
            if(!isValidNum(s))
                return false;
        }
        return true;
    }
    
    private boolean validIPv6(String IP){
        if(IP.charAt(0) == ':') return false;
        if(IP.charAt(IP.length() - 1) == ':') return false;
        String[] IPs = IP.split(":");
        if(IPs.length != 8) return false;
        for(int i = 0; i < 8; i++){
            if(IPs[i] == null) return false;
            if(!isValidHex(IPs[i])) return false;
        }
        return true;
    }
    
    private boolean isValidNum(String s){
        if(s== null || s.length() == 0 || s.length() > 3 || (s.charAt(0) == '0' && s.length() > 1)) return false; // leading zero
        for(int i = 0; i < s.length(); i++)
            if(!Character.isDigit(s.charAt(i))) return false;
        int num = Integer.valueOf(s);
        if(num > 255 || num < 0) return false;
        return true;
    }
    
    private boolean isValidHex(String s){
        if(s == null || s.length() == 0 || s.length() > 4) return false;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(!Character.isDigit(chars[i]) && !(chars[i] <= 'f' && chars[i] >= 'a') && !(chars[i] <= 'F' && chars[i] >= 'A'))
                return false;
        }
        return true;
    }
}