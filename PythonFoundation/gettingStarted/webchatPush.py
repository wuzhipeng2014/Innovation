# WechatPush.py
# encoding: utf-8
import urllib2, json


class WechatPush(object):
    def __init__(self, appid, secrect):
        self.appid = appid
        self.secrect = secrect

    # 获取accessToken
    def getToken(self):
        # 判断缓存
        url = 'https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=' + self.appid + "&secret=" + self.secrect
        f = urllib2.urlopen(url)
        s = f.read()
        # 读取json数据
        j = json.loads(s)
        j.keys()
        token = j['access_token']
        return token

    # 开始推送
    def do_push(self, touser, template_id, url, data, topcolor):
        if topcolor.strip() == '':
            topcolor = "#7B68EE"
        dict_arr = {'touser': touser, 'template_id': template_id, 'url': url, 'topcolor': topcolor, 'data': data}
        json_template = json.dumps(dict_arr)
        token = self.getToken()
        requst_url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + token
        content = self.post_data(requst_url, json_template)
        # 读取json数据
        j = json.loads(content)
        j.keys()
        errcode = j['errcode']
        errmsg = j['errmsg']
        return errmsg

    # 模拟post请求
    def post_data(self, url, para_dct):
        para_data = para_dct
        f = urllib2.urlopen(url, para_data)
        content = f.read()
        return content
