if (window.top !== window.self) {
    document.write = '';
    window.top.location.href = window.self.location.href;
    setTimeout(function () {
        document.body.innerHTML = '';
    }, 0);
}
document.writeln("<!-- BEGIN -->");
document.writeln("<div id=\"bdshare\" class=\"bdshare_t bds_tools_32 get-codes-bdshare\">");
document.writeln("<a class=\"bds_tsina\"></a>");
document.writeln("<a class=\"bds_qzone\"></a>");
document.writeln("<a class=\"bds_tqq\"></a>");
document.writeln("<a class=\"bds_renren\"></a>");
document.writeln("<a class=\"bds_t163\"></a>");
document.writeln("<a class=\"bds_bdhome\"></a>");
document.writeln("<a class=\"bds_mshare\"></a>");
document.writeln("<span class=\"bds_more\"></span>");
document.writeln("<a class=\"shareCount\"></a>");
document.writeln("</div>");
document.writeln("<script type=\"text/javascript\" id=\"bdshare_js\" data=\"type=tools&amp;uid=588050\" ></script>");
document.writeln("<script type=\"text/javascript\" id=\"bdshell_js\"></script>");
document.writeln("<script type=\"text/javascript\">");
document.writeln("document.getElementById(\"bdshell_js\").src = \"http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=\" + Math.ceil(new Date()/3600000)");
document.writeln("</script>");
document.writeln("<!-- END -->");