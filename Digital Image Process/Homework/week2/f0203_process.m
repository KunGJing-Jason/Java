% file = 'D:\IMGProcess\f0203.tif';
% f = imread(file);
% g1 = imadjust(f,[0 1],[1 0]);
% figure;
% imshow(g1)
% g2 = imadjust(f,[0.5 0.75],[1 0]);
% figure;
% imshow(g2)
% g3 = imadjust(f,[],[],2);
% figure;
% imshow(g3)

% f1 = imread('D:\dipÍ¼ºÍmÎÄ¼ş\fch2\f0208.tif');
% imshow(f1);
% figure,imhist(f1)
% ylim('auto')
% g = histeq(f1,256);
% figure,imshow(g)
% figure,imhist(g)
% ylim('auto')

% f1 = imread('D:\pout.tif');
% imshow(f1);
% figure,imhist(f1)
% ylim('auto')
% g = histeq(f1,256);
% figure,imshow(g)
% figure,imhist(g)
% ylim('auto')


f = imread('C:\Users\32183\Desktop\pout.tif');
imshow(f);
figure,imhist(f)


ylim('auto')
g1 = histeq(f,256);
figure,imshow(g1)
figure,imhist(g1)


g = imadjust(f,stretchlim(f),[0.15 0.95]);
figure,imhist(g)
figure;imshow(g)

